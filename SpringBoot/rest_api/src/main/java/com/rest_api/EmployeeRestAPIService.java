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

    public Employee updateEmployee(String employeeId, Employee updatedUmployee){
        for(int i=0; i<employees.size();i++){
            Employee employee = employees.get(i);
                if(employee.getEmployeeId().equals(employeeId)){
                    employees.set(i, updatedUmployee);
                    return updatedUmployee;
                }
          
        }
        System.out.println("Employee Id : "+employeeId+" not found !");
          return null;
    }

    public boolean deleteEmployee(String employeeId){
        return employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
}

}