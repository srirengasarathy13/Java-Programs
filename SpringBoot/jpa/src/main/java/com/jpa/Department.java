package com.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity 
@Table(name = "department")
public class Department{
    @Id
    private String departmentId;
    private String departmentName;
    private String managerName;
    private String location;

    public Department(){

    }
    public Department(String departmentId, String departmentName, String managerName, String location){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.location = location;
    }

    public String getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }

    public String getDepartmentName(){
        return departmentName;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public String getManagerName(){
        return managerName;
    }
    public void setManagerName(String managerName){
        this.managerName = managerName;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
}
