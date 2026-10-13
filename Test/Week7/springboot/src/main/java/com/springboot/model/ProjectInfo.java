
package com.springboot.model;

public class ProjectInfo {

    private String projectId;
    private String projectName;
    private String clientName;
    private String technologyUsed;
    private String projectStatus;

    public ProjectInfo(String projectId, String projectName, String clientName, String technologyUsed, String projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.clientName = clientName;
        this.technologyUsed = technologyUsed;
        this.projectStatus = projectStatus;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTechnologyUsed() {
        return technologyUsed;
    }

    public void setTechnologyUsed(String technologyUsed) {
        this.technologyUsed = technologyUsed;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "\nProject ID: " + projectId + "\nProject Name: " + projectName + "\nClient Name: " + clientName + "\nTechnology Used: " + technologyUsed + "\nProject Status: " + projectStatus;
    }
}
