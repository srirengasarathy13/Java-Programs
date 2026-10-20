package com.config.controller;
import com.config.service.HRMSConfigurationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HRMSConfigurationController
{
    private final HRMSConfigurationService configurationService;
    public HRMSConfigurationController(HRMSConfigurationService configurationService)
    {
        this.configurationService = configurationService;
    }
    @GetMapping("/api/config/environment")
    public String getEnvironment()
    {
        return "Environment: " + configurationService.getEnvironment()
                               + ", Leave Approval Required: "
                               + configurationService.isLeaveApprovalRequired();
    }

    @GetMapping("/api/config/apply-leave")
public String applyLeave(@RequestParam int days) {
    try {
        configurationService.validateLeaveRequest(days);
        return "Leave request for " + days + " days submitted successfully.";
    } catch (IllegalArgumentException e) {
        return e.getMessage(); 
    }
}
}
 