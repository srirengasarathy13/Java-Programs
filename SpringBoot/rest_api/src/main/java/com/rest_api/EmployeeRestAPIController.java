package com.rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController 
@RequestMapping("/api/employees")
public class EmployeeRestAPIController {
    private final EmployeeRestAPIService employeeRestAPIService;
    public EmployeeRestAPIController(EmployeeRestAPIService employeeRestAPIService, EmployeeRestController employeeRestController){
        this.employeeRestAPIService = employeeRestAPIService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRestAPIService.getAllEmployees();
    }
    
    @GetMapping("/{employeeId}")
    public Employee getEmployeeByParameter(@PathVariable String employeeId) {
        return employeeRestAPIService.getEmployeeById(employeeId);
    }
    
}
