package com.course.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registration implements Serializable {
    private final Student student;
    private final Course course;
    private final LocalDateTime registeredAt = LocalDateTime.now();

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getRegisteredAt() {
        return registeredAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
