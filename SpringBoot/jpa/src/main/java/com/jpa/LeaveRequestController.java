package com.jpa;

import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController 
{
    @PostMapping("/apply")
    public String applyLeave(@Valid @RequestBody LeaveRequest request)
    {
        return "Leave request submitted successfully";
    }
}
