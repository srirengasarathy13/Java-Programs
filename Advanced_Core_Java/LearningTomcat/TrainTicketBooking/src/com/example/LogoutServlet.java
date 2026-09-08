
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        /*
         * =========================
         * 1. DESTROY SESSION
         * =========================
         */
        HttpSession session = request.getSession(false);

        if (session != null) {

            session.invalidate();
        }


        /*
         * =========================
         * 2. REMOVE USER ID COOKIE
         * =========================
         */
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if ("userId".equals(cookie.getName())) {

                    /*
                     * Set cookie age to 0
                     * to delete it
                     */
                    cookie.setMaxAge(0);

                    /*
                     * Must use the same path
                     * used when creating the cookie
                     */
                    cookie.setPath(request.getContextPath());

                    /*
                     * Send modified cookie
                     * to browser
                     */
                    response.addCookie(cookie);

                    break;
                }
            }
        }


        /*
         * =========================
         * 3. RETURN TO LOGIN PAGE
         * =========================
         */
        response.sendRedirect("login.html");
    }
}

