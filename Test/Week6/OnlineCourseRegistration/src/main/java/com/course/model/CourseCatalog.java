package com.course.model;

import java.util.List;

public final class CourseCatalog {
    private CourseCatalog() {}
    private static final List<Course> COURSES = List.of(
        new Course("JAVA101", "Java Programming", "Learn Java fundamentals and object-oriented programming."),
        new Course("WEB102", "Web Development", "Learn HTML, CSS, HTTP, Servlets and JSP."),
        new Course("DB103", "Database Fundamentals", "Learn SQL, tables, relationships and queries.")
    );
    public static List<Course> getCourses() { return COURSES; }
    public static Course findById(String id) {
        return COURSES.stream().filter(c -> c.getCourseId().equals(id)).findFirst().orElse(null);
    }
}
