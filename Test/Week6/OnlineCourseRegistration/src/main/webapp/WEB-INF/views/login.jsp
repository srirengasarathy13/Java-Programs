
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Login</title>

    <style>
        body {
            font-family: Arial;
            margin: 40px;
        }

        input {
            margin: 5px 0;
            padding: 5px;
        }

        button {
            padding: 5px 12px;
        }
    </style>
</head>
<body>

    <h2>Student Login</h2>

    <%
        if (request.getAttribute("error") != null) {
    %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <%
        }
    %>

    <%
        if ("1".equals(request.getParameter("logout"))) {
    %>
        <p>You have been logged out.</p>
    <%
        }
    %>

    <form action="${pageContext.request.contextPath}/login" method="post">

        Student ID:<br>
        <input type="text" name="studentId" required>
        <br><br>

        Student Name:<br>
        <input type="text" name="studentName" required>
        <br><br>

        <input type="submit" value="Login">

    </form>

</body>
</html>
