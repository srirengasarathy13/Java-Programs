package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ViewPreferenceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check login
        if (session == null || session.getAttribute("loggedIn") == null) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            return;
        }

        String language =
                (String) session.getAttribute("language");

        String theme =
                (String) session.getAttribute("theme");

        String location =
                (String) session.getAttribute("location");

        // Return JSON
        response.setContentType(
                "application/json"
        );

        PrintWriter out = response.getWriter();

        out.println("{");

        out.println("\"language\": \"" + language + "\",");

        out.println("\"theme\": \"" + theme + "\",");

        out.println("\"location\": \"" + location + "\"");

        out.println("}");
    }
}