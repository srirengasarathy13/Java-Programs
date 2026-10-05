package com.jpa;

import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    public List<Department> getAllDepartments(){    
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(String departmentId){
        return departmentRepository.findById(departmentId).orElse(null);
    }
    public Department createDepartment(Department department)
    {
        return departmentRepository.save(department);
    }
    public Department updateDepartment(String departmentId, Department updatedDepartment){
        if(!departmentRepository.existsById(departmentId)){
            return null;
        }
        updatedDepartment.setDepartmentId(departmentId);
        return departmentRepository.save(updatedDepartment);
    }
    public boolean deleteDepartment(String departmentId){
        if(!departmentRepository.existsById(departmentId)){
            return false;
        }
        departmentRepository.deleteById(departmentId);
        return true;
    }
}


