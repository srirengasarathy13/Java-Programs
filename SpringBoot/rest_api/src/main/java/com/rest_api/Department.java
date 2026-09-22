package com.rest_api;

public class Department{
    private String departmentId;
    private String departmentName;
    private String managerName;
    private String location;

    public Department(String departmentId, String departmentName, String managerName, String location){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.location = location;
    }

    public String getDepartmentId(){
        return departmentId;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public String getManagerName(){
        return managerName;
    }

    public String getLocation(){
        return location;
    }
}
