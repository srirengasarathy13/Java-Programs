package com.rest_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service 
public class EmployeeRestAPIService {
    private final List<Employee> employees  = new ArrayList<>();
    public EmployeeRestAPIService(){
            employees.add(new Employee("AGNI101", "Sri", "Development", "Java Developer"));
            employees.add(new Employee("AGNI102", "Sarathy", "Testing", "Selenium Tester"));

    }
    public List<Employee> getAllEmployees(){
        return employees;
    }

    public Employee getEmployeeById(String employeeId){
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(employeeId)){
                return employee;
            }
            
        }
        return null;
    }

    public Employee createEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }
}
