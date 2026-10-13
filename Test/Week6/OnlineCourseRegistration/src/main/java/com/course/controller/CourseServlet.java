package com.course.controller;

import com.course.model.CourseCatalog;
import com.course.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("student") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastCourse".equals(cookie.getName())) {
                    request.setAttribute("lastCourse", cookie.getValue());
                    break;
                }
            }
        }
        request.setAttribute("courses", CourseCatalog.getCourses());
        request.getRequestDispatcher("/WEB-INF/views/courses.jsp").forward(request, response);
    }
}
