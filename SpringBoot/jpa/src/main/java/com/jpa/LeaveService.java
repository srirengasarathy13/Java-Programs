package com.jpa;

import org.springframework.stereotype.Service;

@Service
public class LeaveService 
{
    public String applyLeave(LeaveRequest request) 
    {
        int availableLeave = 5;

        if(request.getLeaveDays() > availableLeave) 
        {
            return "Leave request rejected. Available leave: " + availableLeave + " days";
        }

        return "Leave request submitted successfully";
    }
}
