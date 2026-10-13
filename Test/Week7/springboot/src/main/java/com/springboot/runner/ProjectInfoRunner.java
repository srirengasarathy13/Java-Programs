package com.springboot.runner;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.ProjectInfo;
import com.springboot.service.ProjectInfoService;

@RestController
public class ProjectInfoRunner {

    private final ProjectInfoService projectInfoService;

    public ProjectInfoRunner(ProjectInfoService projectInfoService) {
        this.projectInfoService = projectInfoService;
    }

    @GetMapping("/projects")
    public List<ProjectInfo> getAllProjects() {
        return projectInfoService.getAllProjects();
    }

    @GetMapping("/projects/{projectId}")
    public ProjectInfo getProjectById(@PathVariable String projectId) {
        return projectInfoService.getProjectById(projectId).orElseThrow(() -> new RuntimeException("Project not found: " + projectId));
    }
}
