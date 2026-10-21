package com.intg.service;
import com.intg.exception.EmployeeNotFoundException;
import com.intg.exception.LeaveNotFoundException;
import com.intg.exception.LeaveRuleException;
import com.intg.model.Leave;
import com.intg.model.LeaveRequest;
import com.intg.repository.EmployeeRepositoryfn;
import com.intg.repository.LeaveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class LeaveService
{
    private static final Logger logger = LoggerFactory.getLogger(LeaveService.class);
    private final LeaveRepository leaveRepository;
    private final EmployeeRepositoryfn employeeRepository;

    public LeaveService(LeaveRepository leaveRepository, EmployeeRepositoryfn employeeRepository)
    {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    public Leave applyLeave(LeaveRequest request)
    {
        logger.info("Processing leave request for employee {}", request.getEmployeeId());

        // Rule 1: Check employee in MySQL
        if (!employeeRepository.existsById(request.getEmployeeId()))
        {
            logger.warn("Employee not found: {}", request.getEmployeeId());
            throw new EmployeeNotFoundException("Employee " + request.getEmployeeId()
                                                            + " not found");
        }

        // Rule 2: Maximum five days per request
        if (request.getLeaveDays() > 5)
        {
            logger.warn("Leave request rejected: maximum five days allowed");
            throw new LeaveRuleException("You can apply for a maximum of 5 leave days");
        }

        // Create the leave entity
        Leave leave = new Leave();
        String id = "L" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
        leave.setLeaveId(id);
        leave.setEmployeeId(request.getEmployeeId());
        leave.setLeaveType(request.getLeaveType());
        leave.setLeaveDays(request.getLeaveDays());
        leave.setReason(request.getReason());
        leave.setStatus("PENDING");

        // Save the leave request to MySQL
        Leave savedLeave = leaveRepository.save(leave);
        logger.info("Leave saved successfully with ID {}",
                savedLeave.getLeaveId());
        return savedLeave;
    }

    public Leave getLeaveById(String leaveId)
    {
        logger.info("Searching for leave ID: {}", leaveId);
        return leaveRepository.findById(leaveId).orElseThrow(() ->
                        new LeaveNotFoundException(
                                "Leave not found with ID: "
                                        + leaveId));
    }

    public List<Leave> getAllLeaves()
    {
        logger.info("Retrieving all leave requests");
        return leaveRepository.findAll();
    }
}
 