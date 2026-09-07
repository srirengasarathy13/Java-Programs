package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SavePreferenceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check login
        if (session == null || session.getAttribute("loggedIn") == null) {

            response.sendRedirect("login.html");
            return;
        }

        // Get form data
        String language = request.getParameter("language");
        String theme = request.getParameter("theme");
        String location = request.getParameter("location");

        // Save in session
        session.setAttribute("language", language);
        session.setAttribute("theme", theme);
        session.setAttribute("location", location);

        // Go to HTML page
        response.sendRedirect("viewPreference.html");
    }
}