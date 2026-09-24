package com.rest_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service 
public class DepartmentRestAPIService {
    private final List<Department> departments  = new ArrayList<>();
    public DepartmentRestAPIService(){
            departments.add(new Department("Dept101", "Development", "Sri", "Chennai"));
            departments.add(new Department("Dept102", "HR", "Sarathy", "Chennai"));

    }
    public List<Department> getAllDepartments(){
        return departments;
    }

    public Department getDepartmentById(String departmentId){
        for(Department department : departments){
            if(department.getDepartmentId().equals(departmentId)){
                return department;
            }
            
        }
        return null;
    }

       public Department createDepartment(Department department){
        departments.add(department);
        return department;
    }

    public Department updateDepartment(String departmentId, Department updatedDepartment){
        for(int i=0; i<departments.size(); i++){
            Department department = departments.get(i);
            if(department.getDepartmentId().equals(departmentId)){
                departments.set(i,updatedDepartment);
                return updatedDepartment;
            }
        }
        System.out.println("Department Id :"+departmentId+" not found !");
        return null;
    }
}
