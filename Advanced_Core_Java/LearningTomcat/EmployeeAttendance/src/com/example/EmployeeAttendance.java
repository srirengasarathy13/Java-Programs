package com.example;

public class EmployeeAttendance {
    private String employeeId;
    private String employeeName;
    private String month;
    private int year;
    private int presentDays;
    private int absentDays;
    
    public EmployeeAttendance(String employeeId, String employeeName, String month, int year, int presentDays, int absentDays){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.month = month;
        this.year = year;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public String getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public int getPresentDays(){
        return presentDays;
    }

    public int getAbsentDays(){
        return absentDays;
    }
}
