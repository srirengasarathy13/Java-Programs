package com.rest_api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
public class EmployeeRestController {
    @GetMapping("/api/employee")
    public Employee getEmployee() {
        return new Employee("AGNI101", "R Sri Rengasarathy", "IT", "Java Developer");
    }
    
}
