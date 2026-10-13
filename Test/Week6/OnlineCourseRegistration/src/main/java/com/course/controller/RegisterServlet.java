package com.course.controller;

import com.course.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || !(session.getAttribute("student") instanceof Student)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String courseId = request.getParameter("courseId");
        Course course = CourseCatalog.findById(courseId == null ? "" : courseId);
        if (course == null) {
            request.setAttribute("error", "Please select a valid course.");
            request.setAttribute("courses", CourseCatalog.getCourses());
            request.getRequestDispatcher("/WEB-INF/views/courses.jsp").forward(request, response);
            return;
        }

        Student student = (Student) session.getAttribute("student");
        Registration registration = new Registration(student, course);
        session.setAttribute("registration", registration);

        Cookie preference = new Cookie("lastCourse",
                URLEncoder.encode(course.getCourseName(), StandardCharsets.UTF_8));
        preference.setMaxAge(30 * 24 * 60 * 60);
        preference.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
        preference.setHttpOnly(true);
        response.addCookie(preference);

        response.sendRedirect(request.getContextPath() + "/result");
    }
}
