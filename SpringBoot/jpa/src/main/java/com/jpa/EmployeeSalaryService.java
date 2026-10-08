package com.jpa;

import org.springframework.stereotype.Service;

@Service
public class EmployeeSalaryService {

    public String checkSalaryApproval(EmployeeSalary employeeSalary) {
        if (employeeSalary.getSalary() < 20000) {
            return "Salary approval rejected";
        }
        
        return "Salary approved";
    }
}
