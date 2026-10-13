<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.course.model.Student,com.course.model.Course,java.util.List,java.net.URLDecoder,java.nio.charset.StandardCharsets" %>

<%
    Student student = (Student) session.getAttribute("student");

    if (student == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }

    List<Course> courses = (List<Course>) request.getAttribute("courses");
    String lastCourse = (String) request.getAttribute("lastCourse");

    if (lastCourse != null) {
        try {
            lastCourse = URLDecoder.decode(lastCourse, StandardCharsets.UTF_8);
        } catch (Exception ignored) {}
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>

    <style>
        body {
            font-family: Arial;
            margin: 30px;
        }

        input, button {
            margin: 5px;
            padding: 5px;
        }

        .course {
            margin: 15px 0;
        }
    </style>
</head>
<body>

    <h2>Welcome, <%= student.getStudentName() %>!</h2>

    <p>Student ID: <%= student.getStudentId() %></p>

    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout">
    </form>

    <hr>

    <%
        if (lastCourse != null) {
    %>
        <p>Your last selected course: <%= lastCourse %></p>
    <%
        }
    %>

    <h3>Available Courses</h3>

    <%
        if (request.getAttribute("error") != null) {
    %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <%
        }
    %>

    <form action="${pageContext.request.contextPath}/register" method="post">

        <%
            if (courses != null) {
                for (Course course : courses) {
        %>

            <div class="course">
                <input type="radio" name="courseId"
                       value="<%= course.getCourseId() %>" required>

                <strong><%= course.getCourseName() %></strong>
                (<%= course.getCourseId() %>)

                <p><%= course.getDescription() %></p>
            </div>

        <%
                }
            }
        %>

        <br>
        <input type="submit" value="Register">

    </form>

</body>
</html>
