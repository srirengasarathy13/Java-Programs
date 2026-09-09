package com.example;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/attendance")
public class HRMSAttendanceServlet extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        EmployeeAttendance attendance = new EmployeeAttendance("EMP1001","Rama","September",2026,20,2);
        request.setAttribute("attendance", attendance);
        request.getRequestDispatcher("employeeAttendance.jsp").forward(request, response);
    }

}
