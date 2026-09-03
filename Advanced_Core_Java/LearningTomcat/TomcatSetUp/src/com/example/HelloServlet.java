package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

@Override
protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    String path = request.getServletPath();

    if ("/login".equals(path)) {

        login(request, response);

    } else if ("/register".equals(path)) {

        register(request, response);

    }
}


private void login(
        HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    System.out.println("========== LOGIN ==========");
    System.out.println("Username : " + username);
    System.out.println("Password : " + password);
    System.out.println("===========================");

    /*
     * For now we are not checking a database.
     * We simply redirect to the dashboard.
     */

    response.sendRedirect("dashboard.html");
}


private void register(
        HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {

    String fullname = request.getParameter("fullname");
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmPassword =
            request.getParameter("confirmPassword");

    System.out.println("========= REGISTER =========");
    System.out.println("Full Name : " + fullname);
    System.out.println("Username  : " + username);
    System.out.println("Email     : " + email);
    System.out.println("Password  : " + password);
    System.out.println("Confirm   : " + confirmPassword);
    System.out.println("============================");

    /*
     * For now we only check whether
     * both passwords are the same.
     */

    if (!password.equals(confirmPassword)) {

        response.setContentType("text/html");

        response.getWriter().println(
            "<h2>Password does not match!</h2>" +
            "<a href='register.html'>Go Back</a>"
        );

        return;
    }

    /*
     * Registration successful.
     * Later we will save the user into MySQL.
     */

    response.sendRedirect("index.html");
}


}
