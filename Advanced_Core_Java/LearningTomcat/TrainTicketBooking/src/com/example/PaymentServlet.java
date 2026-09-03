package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class PaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        /*
         * Check login
         */
        if (session == null ||
            session.getAttribute("loggedIn") == null) {

            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<title>Dummy Payment</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background: #f4f6f8;");
        out.println("text-align: center;");
        out.println("padding: 40px;");
        out.println("}");

        out.println(".payment-box {");
        out.println("background: white;");
        out.println("width: 420px;");
        out.println("margin: auto;");
        out.println("padding: 30px;");
        out.println("border-radius: 12px;");
        out.println("box-shadow: 0 5px 20px rgba(0,0,0,0.15);");
        out.println("}");

        out.println("img {");
        out.println("width: 230px;");
        out.println("height: 230px;");
        out.println("margin: 20px;");
        out.println("}");

        out.println("button {");
        out.println("padding: 12px 25px;");
        out.println("background: #28a745;");
        out.println("color: white;");
        out.println("border: none;");
        out.println("border-radius: 6px;");
        out.println("font-size: 16px;");
        out.println("cursor: pointer;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='payment-box'>");

        out.println("<h2>Dummy Payment</h2>");

        out.println("<p>Scan the QR Code to Pay</p>");

        /*
         * QR image
         */
        out.println("<img src='qr.png' alt='QR Code'>");

        out.println("<h3>Amount: ₹450</h3>");

        out.println("<p>Use any UPI application to scan.</p>");

        out.println("<form action='payment' method='post'>");

        out.println("<button type='submit'>");
        out.println("Payment Done");
        out.println("</button>");

        out.println("</form>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }


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

        /*
         * Dummy payment successful
         */
        session.setAttribute("paymentStatus", "SUCCESS");

        /*
         * Go to confirmation
         */
        response.sendRedirect("confirmation");
    }
}