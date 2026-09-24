package com.rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;



@RestController 
@RequestMapping("/api/departments")
public class DepartmentRestAPIController {
    private final DepartmentRestAPIService departmentRestAPIService;
    public DepartmentRestAPIController(DepartmentRestAPIService departmentRestAPIService){
        this.departmentRestAPIService = departmentRestAPIService;
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentRestAPIService.getAllDepartments();
    }
    
    @GetMapping("/{departmentId}")
    public Department getDepartmentByParameter(@PathVariable String departmentId) {
        return departmentRestAPIService.getDepartmentById(departmentId);
    }

    @PostMapping
    public Department creatEmployee(@RequestBody Department department) {
      return departmentRestAPIService.createDepartment(department);
    }
    
    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId, @RequestBody Department updatedDepartment){
     return departmentRestAPIService.updateDepartment(departmentId, updatedDepartment);
    }
}
