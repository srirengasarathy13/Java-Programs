package com.hrms;

public class Employee {

    private String employeeId;
    private String name;
    private String company;
    private String location;

    public Employee(String employeeId, String name, String company, String location) {
        this.employeeId = employeeId;
        this.name = name;
        this.company = company;
        this.location = location;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }
}