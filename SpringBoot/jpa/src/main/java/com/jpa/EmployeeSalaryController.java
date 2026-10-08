package com.jpa;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary")
public class EmployeeSalaryController {

    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
        this.employeeSalaryService = employeeSalaryService;
    }

    @PostMapping
    public String processSalary(@Valid @RequestBody EmployeeSalary request) {
        return employeeSalaryService.checkSalaryApproval(request);
    }
}
