
package com.course.controller;

import com.course.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String VALID_STUDENT_ID = "STU101";
    private static final String VALID_STUDENT_NAME = "Sri Rengasarathy";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("studentId");
        String name = request.getParameter("studentName");

        if (id == null || name == null
                || !VALID_STUDENT_ID.equals(id.trim())
                || !VALID_STUDENT_NAME.equals(name.trim())) {

            request.setAttribute(
                    "error",
                    "Invalid Student ID or Student Name. Please try again."
            );

            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                   .forward(request, response);
            return;
        }

        HttpSession oldSession = request.getSession(false);

        if (oldSession != null) {
            oldSession.invalidate();
        }

        HttpSession session = request.getSession(true);

        Student student = new Student(
                VALID_STUDENT_ID,
                VALID_STUDENT_NAME
        );

        session.setAttribute("student", student);

        session.setMaxInactiveInterval(30 * 60);
        response.sendRedirect(
                request.getContextPath() + "/courses"
        );
    }
}
