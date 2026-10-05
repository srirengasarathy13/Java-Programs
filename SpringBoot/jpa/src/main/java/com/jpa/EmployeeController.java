package com.jpa;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController{
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService =  employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable String employeeId, @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployee(employeeId, updatedEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        if(employeeService.deleteEmployee(employeeId)){
            return "Employee "+employeeId+" deleted successfully.";
        }
        return "Employee not found.";
    }
}

