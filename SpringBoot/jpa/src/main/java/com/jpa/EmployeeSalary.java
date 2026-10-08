package com.jpa;

import jakarta.validation.constraints.*;

public class EmployeeSalary {

    @NotBlank(message = "Employee ID cannot be blank")
    @Pattern(regexp = "EMP[0-9]{4}", message = "Employee ID must be in format EMP followed by 4 digits")
    private String employeeId;

    @NotBlank(message = "Employee name cannot be blank")
    private String employeeName;

    @Positive(message = "Salary must be a positive number")
    @DecimalMin(value = "15000.00", message = "Salary must be at least 15000.00")
    private double salary;

    // Default Constructor
    public EmployeeSalary() {
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
