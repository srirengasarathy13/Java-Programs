package com.course.model;

import java.io.Serializable;

public class Student implements Serializable {
    private final String studentId;
    private final String studentName;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
}
