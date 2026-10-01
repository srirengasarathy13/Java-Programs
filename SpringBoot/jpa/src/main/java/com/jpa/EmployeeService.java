package com.jpa;

import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployees(){    
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(String employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }
    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
}


