
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class TrainServlet extends HttpServlet {

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
            session.getAttribute("loggedIn") == null) {

            response.sendRedirect("login.html");
            return;
        }


        /*
         * =========================
         * 2. READ USER ID COOKIE
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
         * 3. GET SELECTED TRAIN
         * =========================
         */
        String train = request.getParameter("train");


        /*
         * =========================
         * 4. STORE TRAIN IN SESSION
         * =========================
         */
        session.setAttribute("train", train);


        /*
         * Store cookie user ID in session
         * as well, if cookie exists
         */
        if (userId != null) {
            session.setAttribute("userId", userId);
        }


        /*
         * =========================
         * 5. GO TO SEAT SELECTION
         * =========================
         */
        response.sendRedirect("seats.html");
    }
}

