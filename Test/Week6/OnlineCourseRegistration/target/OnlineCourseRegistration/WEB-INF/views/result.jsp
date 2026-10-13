
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.course.model.Registration,com.course.model.Student" %>

<%
    Registration registration = (Registration) request.getAttribute("registration");
    Student student = (Student) session.getAttribute("student");

    if (registration == null || student == null) {
        response.sendRedirect(request.getContextPath() + "/courses");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Complete</title>

    <style>
        body {
            font-family: Arial;
            margin: 30px;
        }

        button, a {
            margin: 5px;
            padding: 5px;
        }

        .details p {
            margin: 12px 0;
        }
    </style>
</head>
<body>

    <h2>Registration Successful!</h2>

    <h3>Registration Details</h3>

    <div class="details">

        <p>
            Student ID:
            <strong><%= registration.getStudent().getStudentId() %></strong>
        </p>

        <p>
            Student Name:
            <strong><%= registration.getStudent().getStudentName() %></strong>
        </p>

        <p>
            Course ID:
            <strong><%= registration.getCourse().getCourseId() %></strong>
        </p>

        <p>
            Course Name:
            <strong><%= registration.getCourse().getCourseName() %></strong>
        </p>

        <p>
            Registered At:
            <strong><%= registration.getRegisteredAt() %></strong>
        </p>

    </div>

    <p>Your selected course has been saved in a browser cookie for 30 days.</p>

    <a href="${pageContext.request.contextPath}/courses">
        Choose Another Course
    </a>

    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout">
    </form>

</body>
</html>