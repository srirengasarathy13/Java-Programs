
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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

        /*
         * =========================
         * 1. GET EXISTING SESSION
         * =========================
         */
        HttpSession session = request.getSession(false);

        /*
         * Check login session
         */
        if (session == null ||
            !Boolean.TRUE.equals(session.getAttribute("loggedIn"))) {

            response.sendRedirect("login.html");
            return;
        }


        /*
         * =========================
         * 2. READ USER ID FROM COOKIE
         * =========================
         */
        String userId = null;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if ("userId".equals(cookie.getName())) {

                    userId = cookie.getValue();
                    break;
                }
            }
        }


        /*
         * =========================
         * 3. GET SELECTED SEAT
         * =========================
         */
        String seat = request.getParameter("seat");


        /*
         * =========================
         * 4. STORE SEAT IN SESSION
         * =========================
         */
        session.setAttribute("seat", seat);


        /*
         * =========================
         * 5. STORE COOKIE USER ID
         * IN SESSION
         * =========================
         */
        if (userId != null) {

            session.setAttribute("userId", userId);
        }


        /*
         * =========================
         * 6. GO TO PAYMENT
         * =========================
         */
        response.sendRedirect("payment");
    }
}

