package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfirmationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        /*
         * Check session
         */
        if (session == null ||
            session.getAttribute("loggedIn") == null) {

            response.sendRedirect("login.html");
            return;
        }

        String userId =
                (String) session.getAttribute("userId");

        String train =
                (String) session.getAttribute("train");

        String seat =
                (String) session.getAttribute("seat");

        String paymentStatus =
                (String) session.getAttribute("paymentStatus");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");

        out.println("<head>");
        out.println("<title>Booking Confirmation</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background: #f4f6f8;");
        out.println("padding: 40px;");
        out.println("}");

        out.println(".confirmation {");
        out.println("background: white;");
        out.println("max-width: 500px;");
        out.println("margin: auto;");
        out.println("padding: 30px;");
        out.println("border-radius: 12px;");
        out.println("box-shadow: 0 5px 20px rgba(0,0,0,0.15);");
        out.println("}");

        out.println("h2 {");
        out.println("text-align: center;");
        out.println("}");

        out.println(".success {");
        out.println("text-align: center;");
        out.println("color: green;");
        out.println("font-size: 20px;");
        out.println("font-weight: bold;");
        out.println("}");

        out.println(".details {");
        out.println("margin-top: 25px;");
        out.println("line-height: 2;");
        out.println("}");

        out.println(".logout {");
        out.println("display: block;");
        out.println("text-align: center;");
        out.println("margin-top: 25px;");
        out.println("background: #d32f2f;");
        out.println("color: white;");
        out.println("padding: 12px;");
        out.println("text-decoration: none;");
        out.println("border-radius: 6px;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='confirmation'>");

        out.println("<h2>Booking Confirmation</h2>");

        out.println("<p class='success'>");
        out.println("✓ Booking Confirmed");
        out.println("</p>");

        out.println("<div class='details'>");

        out.println("<b>Passenger ID:</b> ");
        out.println(userId);
        out.println("<br>");

        out.println("<b>Train:</b> ");
        out.println(train);
        out.println("<br>");

        out.println("<b>Seat:</b> ");
        out.println(seat);
        out.println("<br>");

        out.println("<b>Amount:</b> ₹450");
        out.println("<br>");

        out.println("<b>Payment:</b> ");
        out.println(paymentStatus);

        out.println("</div>");

        out.println("<a class='logout' href='logout'>");
        out.println("Logout");
        out.println("</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}