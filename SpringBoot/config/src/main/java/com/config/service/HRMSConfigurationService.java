package com.config.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HRMSConfigurationService
{
    @Value("${config.environment}")
    private String environment;
    @Value("${config.leave.approval.required}")
    private boolean leaveApprovalRequired;
    @Value("${config.leave.max-days}")
    private int maxLeaveDays;

    public String getEnvironment()
    {
        return environment;
    }
    public boolean isLeaveApprovalRequired()
    {
        return leaveApprovalRequired;
    }
    public void validateLeaveRequest(int requestedDays) {
        if (requestedDays > maxLeaveDays) {
            throw new IllegalArgumentException("Leave request rejected! Maximum allowed leave days in " 
                    + environment + " environment is " + maxLeaveDays + " days.");
        }
    }

}
 