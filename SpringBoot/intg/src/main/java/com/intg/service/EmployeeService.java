package com.intg.service;

import com.intg.exception.EmployeeNotFoundException;
import com.intg.model.Employee;
import com.intg.repository.EmployeeRepositoryfn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepositoryfn employeeRepository;

    public EmployeeService(EmployeeRepositoryfn employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        logger.info("Registering a new employee with ID: {}", employee.getEmployeeId());
        
        // Optional Rule: Check if the employee ID is already taken
        if (employeeRepository.existsById(employee.getEmployeeId())) {
            logger.warn("Registration failed. Employee ID {} already exists", employee.getEmployeeId());
            throw new IllegalArgumentException("Employee ID " + employee.getEmployeeId() + " already exists!");
        }

        Employee savedEmployee = employeeRepository.save(employee);
        logger.info("Employee {} saved successfully", savedEmployee.getEmployeeId());
        return savedEmployee;
    }

    public Employee getEmployeeById(String employeeId) {
        logger.info("Searching for employee ID: {}", employeeId);
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
    }

    public List<Employee> getAllEmployees() {
        logger.info("Retrieving all registered employees");
        return employeeRepository.findAll();
    }
}
