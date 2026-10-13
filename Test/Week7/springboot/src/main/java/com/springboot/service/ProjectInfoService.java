
package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.model.ProjectInfo;

@Service
public class ProjectInfoService {

    private final List<ProjectInfo> projects = new ArrayList<>();

    public ProjectInfoService() {
        projects.add(new ProjectInfo("P101","HR Management System","Agnie Consulting","Java, Spring Boot, MySQL","Completed"));
        projects.add(new ProjectInfo("P102","Online Course Registration","Sethu Institute of Technology","Java, JSP, MySQL","In Progress"));
        projects.add(new ProjectInfo("P103","Employee Attendance System","Agnie Consulting","Spring Boot, MySQL, Postman","Under Development"));
    }

    public List<ProjectInfo> getAllProjects() {
        return projects;
    }

    public Optional<ProjectInfo> getProjectById(String projectId) {
        for (ProjectInfo project : projects) {
            if (project.getProjectId().equalsIgnoreCase(projectId)) {
                return Optional.of(project);
            }
        }

        return Optional.empty();
    }
}
