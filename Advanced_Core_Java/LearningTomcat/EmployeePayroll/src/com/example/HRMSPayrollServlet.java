package src.com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/payroll")
public class HRMSPayrollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        EmployeePayroll payroll =
            new EmployeePayroll(
                "EMP1001",
                "Rama",
                "September",
                2026,
                30000,
                5000,
                3000
            );

        request.setAttribute("payroll", payroll);

        request.getRequestDispatcher("employeePayroll.jsp")
               .forward(request, response);
    }
}