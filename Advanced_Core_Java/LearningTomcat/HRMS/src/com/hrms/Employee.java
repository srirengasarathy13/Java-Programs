package com.hrms;

public class Employee {

    private String employeeId;
    private String employeeName;
    private String department;
    private String designation;

    public Employee(String employeeId,
                    String employeeName,
                    String department,
                    String designation) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.designation = designation;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }
}