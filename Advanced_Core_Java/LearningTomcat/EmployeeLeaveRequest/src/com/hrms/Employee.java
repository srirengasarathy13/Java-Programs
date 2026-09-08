package com.hrms;

public class Employee {

    private String employeeId;
    private String employeeName;
    private String department;
    private String leaveRequest;
    private String leaveReason;
    private String startDate;
    private String endDate;

    public Employee(String employeeId,
                    String employeeName,
                    String department,
                    String leaveRequest,
                    String leaveReason,
                    String startDate,
                    String endDate) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.leaveRequest = leaveRequest;
        this.leaveReason = leaveReason;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getLeaveRequest() {
        return leaveRequest;
    }

    public String getLeaveReason(){
        return leaveReason;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }
}