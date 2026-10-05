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
    public Employee updateEmployee(String employeeId, Employee updatedEmployee){
        if(!employeeRepository.existsById(employeeId)){
            return null;
        }
        updatedEmployee.setEmployeeId(employeeId);
        return employeeRepository.save(updatedEmployee);
    }
    public boolean deleteEmployee(String employeeId){
        if(!employeeRepository.existsById(employeeId)){
            return false;
        }
        employeeRepository.deleteById(employeeId);
        return true;
    }
}


