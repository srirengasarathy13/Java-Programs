package com.jpa;

import com.jpa.LeaveRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController 
{
    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) 
    {
        this.leaveService = leaveService;
    }

    @PostMapping("/apply")
    public String applyLeave(@Valid @RequestBody LeaveRequest request) 
    {
        return leaveService.applyLeave(request);
    }
}
