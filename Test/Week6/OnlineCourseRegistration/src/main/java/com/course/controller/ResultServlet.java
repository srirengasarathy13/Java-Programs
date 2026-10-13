package com.course.controller;

import com.course.model.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("student") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        if (!(session.getAttribute("registration") instanceof Registration)) {
            response.sendRedirect(request.getContextPath() + "/courses");
            return;
        }
        request.setAttribute("registration", session.getAttribute("registration"));
        request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
    }
}
