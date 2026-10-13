package com.jpa;
import com.jpa.exception.LeaveNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class LeaveService
{
    private final Map<String, LeaveRequest> leaveRequests = new HashMap<>();
    public LeaveService()
    {
        // Sample data for Day 3 demonstration
        LeaveRequest request = new LeaveRequest();
        request.setEmployeeId("EMP1001");
        request.setLeaveType("Casual Leave");
        request.setLeaveDays(3);
        request.setReason("Family function");
        leaveRequests.put("L1001", request);
    }
    public String applyLeave(LeaveRequest request)
    {
        // Simulating employee's available leave balance
        int availableLeave = 5;
        // Business validation
        if(request.getLeaveDays() > availableLeave)
        {
            return "Leave request rejected. Available leave: " + availableLeave + " days";
        }
        return "Leave request submitted successfully";
    }
    public LeaveRequest getLeaveById(String leaveId)
    {
        LeaveRequest request = leaveRequests.get(leaveId);
        if (request == null)
        {
            throw new LeaveNotFoundException("Leave request " + leaveId + " not found");
        }
        return request;
    }
}