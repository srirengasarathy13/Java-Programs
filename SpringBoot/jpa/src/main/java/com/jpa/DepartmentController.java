package com.jpa;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController{
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService =  departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
    
    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") String departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }
}
