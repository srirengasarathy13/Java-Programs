package com.jpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeOnboardingController {

    @PostMapping("/onboarding")
    public String onboardEmployee(@Valid @RequestBody EmployeeOnboardingRequest request) {
        return "Employee onboarded successfully";
    }
}
