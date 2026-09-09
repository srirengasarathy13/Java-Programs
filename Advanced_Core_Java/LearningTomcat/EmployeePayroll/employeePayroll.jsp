<%@ page import="src.com.example.EmployeePayroll" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Employee Payroll</title>
</head>

<body>

    <h2>HRMS Employee Payroll</h2>

    <%
        EmployeePayroll payroll =
            (EmployeePayroll) request.getAttribute("payroll");
    %>

    <p>Employee ID : <%= payroll.getEmployeeId() %></p>

    <p>Employee Name : <%= payroll.getEmployeeName() %></p>

    <p>Month : <%= payroll.getMonth() %></p>

    <p>Year : <%= payroll.getYear() %></p>

    <p>Basic Salary : ₹<%= payroll.getBasicSalary() %></p>

    <p>Allowances : ₹<%= payroll.getAllowances() %></p>

    <p>Deductions : ₹<%= payroll.getDeductions() %></p>

    <p>Net Salary : ₹<%= payroll.getNetSalary() %></p>

</body>

</html>