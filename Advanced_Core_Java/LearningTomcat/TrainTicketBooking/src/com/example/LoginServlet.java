package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        /*
         * Dummy login credentials
         */
        if ("sri".equals(userId) && "1234".equals(password)) {

            /*
             * Create session
             */
            HttpSession session = request.getSession();

            session.setAttribute("userId", userId);
            session.setAttribute("loggedIn", true);

            /*
             * Redirect to train selection
             */
            response.sendRedirect("trains.html");

        } else {

            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head><title>Login Failed</title></head>");
            out.println("<body>");

            out.println("<h2>Invalid User ID or Password</h2>");

            out.println("<a href='login.html'>");
            out.println("Try Again");
            out.println("</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}