package com.hrms;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController 
public class EmployeeController {
    private final EmployeeService empService;
    public EmployeeController(EmployeeService empService){
        this.empService = empService;
    }

    @GetMapping("/employee")
    public String getEmployee(@RequestParam String empId) {
        return empService.getEmployeeInfo(empId);
    }
    
}
