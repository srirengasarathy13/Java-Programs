package com.jpa.service;
import com.jpa.exception.LeaveNotFoundException;
import com.jpa.exception.LeaveRuleException;
import com.jpa.model.Leave;
import com.jpa.model.LeaveRequest;
import com.jpa.repository.LeaveRepository;
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
    public LeaveService(LeaveRepository leaveRepository)
    {
        this.leaveRepository = leaveRepository;
    }
    public Leave applyLeave(LeaveRequest request)
    {
        logger.info("Processing leave request for {}", request.getEmployeeId());
        // Business rule: maximum 5 days per request
        if (request.getLeaveDays() > 5)
        {
            logger.warn("Leave request rejected: maximum 5 days allowed");
            throw new LeaveRuleException("You can apply for a maximum of 5 leave days");
        }
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
        Leave savedLeave = leaveRepository.save(leave);
        logger.info("Leave saved successfully with ID {}", savedLeave.getLeaveId());
        return savedLeave;
    }

    public Leave getLeaveById(String leaveId)
    {
        return leaveRepository.findById(leaveId).orElseThrow(() -> new LeaveNotFoundException(
                                                        "Leave not found with ID: " + leaveId));
    }

    public List<Leave> getAllLeaves()
    {
        return leaveRepository.findAll();
    }
}