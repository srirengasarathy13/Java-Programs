package com.course.model;

import java.io.Serializable;

public class Course implements Serializable {
    private final String courseId;
    private final String courseName;
    private final String description;

    public Course(String courseId, String courseName, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
    }
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getDescription() { return description; }
}
