package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SeatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        /*
         * Session check
         */
        if (session == null ||
            session.getAttribute("loggedIn") == null) {

            response.sendRedirect("login.html");
            return;
        }

        String seat = request.getParameter("seat");

        /*
         * Store seat
         */
        session.setAttribute("seat", seat);

        /*
         * Go to payment
         */
        response.sendRedirect("payment");
    }
}