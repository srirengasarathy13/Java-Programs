
package com.hrms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/leaveRequest")
public class HRMSEmployeeProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Employee Profile Requested");

        // Create Model
        Employee employee = new Employee(
                "EMP1001",
                "Rama",
                "IT",
                "Approved",
                "Sick Leave",
                "10.09.2026",
                "17.06.2026"
        );

        // Send Model data to View
        request.setAttribute("employee", employee);

        // Forward request to JSP
        request.getRequestDispatcher("/leaveRequest.jsp")
               .forward(request, response);
    }
}