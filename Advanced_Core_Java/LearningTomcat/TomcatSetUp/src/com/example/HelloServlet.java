package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String path = request.getServletPath();

        // HOME PAGE
        if (path.equals("/")) {

            out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Welcome</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background: #f4f6f8;
                            text-align: center;
                            padding-top: 100px;
                        }

                        .card {
                            width: 450px;
                            margin: auto;
                            background: white;
                            padding: 40px;
                            border-radius: 15px;
                            box-shadow: 0 8px 25px rgba(0,0,0,0.12);
                        }

                        h1 {
                            color: #222;
                        }

                        p {
                            color: #555;
                            font-size: 18px;
                        }

                        a {
                            display: inline-block;
                            margin-top: 20px;
                            padding: 12px 25px;
                            background: #16803c;
                            color: white;
                            text-decoration: none;
                            border-radius: 6px;
                        }
                    </style>
                </head>

                <body>

                    <div class="card">

                        <h1>Welcome to Employee Management System</h1>

                        <p>Manage your employee registrations easily.</p>

                        <a href="register">
                            Register Employee
                        </a>

                    </div>

                </body>
                </html>
                """);

        }

        // REGISTRATION FORM
        else if (path.equals("/register")) {

            out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Employee Registration</title>

                    <style>
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #f4f6f8;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            min-height: 100vh;
                        }

                        .card {
                            width: 420px;
                            background: white;
                            padding: 30px;
                            border-radius: 15px;
                            box-shadow: 0 8px 25px rgba(0,0,0,0.12);
                        }

                        h1 {
                            text-align: center;
                            color: #222;
                            margin-bottom: 25px;
                        }

                        label {
                            display: block;
                            margin-top: 15px;
                            margin-bottom: 6px;
                            font-weight: bold;
                            color: #555;
                        }

                        input {
                            width: 100%;
                            padding: 10px;
                            box-sizing: border-box;
                            border: 1px solid #ccc;
                            border-radius: 6px;
                            font-size: 15px;
                        }

                        button {
                            width: 100%;
                            margin-top: 25px;
                            padding: 12px;
                            background: #16803c;
                            color: white;
                            border: none;
                            border-radius: 6px;
                            font-size: 16px;
                            cursor: pointer;
                        }

                        button:hover {
                            background: #126b32;
                        }
                    </style>
                </head>

                <body>

                    <div class="card">

                        <h1>Employee Registration</h1>

                        <form method="post" action="employee">

                            <label>Employee ID</label>
                            <input type="number"
                                   name="employeeId"
                                   required>

                            <label>Name</label>
                            <input type="text"
                                   name="name"
                                   required>

                            <label>Department</label>
                            <input type="text"
                                   name="department"
                                   required>

                            <label>Designation</label>
                            <input type="text"
                                   name="designation"
                                   required>

                            <button type="submit">
                                Register Employee
                            </button>

                        </form>

                    </div>

                </body>
                </html>
                """);
        }
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String employeeId = request.getParameter("employeeId");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>Employee Registered</title>

                <style>
                    body {
                        margin: 0;
                        font-family: Arial, sans-serif;
                        background: #f4f6f8;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                    }

                    .card {
                        width: 420px;
                        background: white;
                        padding: 30px;
                        border-radius: 15px;
                        box-shadow: 0 8px 25px rgba(0,0,0,0.12);
                    }

                    h1 {
                        text-align: center;
                        color: #222;
                    }

                    .success {
                        text-align: center;
                        color: #16803c;
                        font-weight: bold;
                        font-size: 18px;
                        margin-bottom: 25px;
                    }

                    .detail {
                        display: flex;
                        justify-content: space-between;
                        padding: 15px 5px;
                        border-bottom: 1px solid #eee;
                    }

                    .label {
                        font-weight: bold;
                        color: #555;
                    }

                    .value {
                        color: #222;
                    }

                    .status {
                        color: #16803c;
                        font-weight: bold;
                    }

                    a {
                        display: block;
                        text-align: center;
                        margin-top: 25px;
                        color: #16803c;
                        text-decoration: none;
                        font-weight: bold;
                    }
                </style>
            </head>

            <body>

                <div class="card">

                    <h1>Employee Details</h1>

                    <div class="success">
                        Employee registered successfully!
                    </div>
            """);

        out.println("""
                    <div class="detail">
                        <span class="label">Employee ID</span>
                        <span class="value">""" + employeeId + """
                        </span>
                    </div>

                    <div class="detail">
                        <span class="label">Name</span>
                        <span class="value">""" + name + """
                        </span>
                    </div>

                    <div class="detail">
                        <span class="label">Department</span>
                        <span class="value">""" + department + """
                        </span>
                    </div>

                    <div class="detail">
                        <span class="label">Designation</span>
                        <span class="value">""" + designation + """
                        </span>
                    </div>

                    <div class="detail">
                        <span class="label">Status</span>
                        <span class="status">Active</span>
                    </div>

                    <a href="register">
                        Register Another Employee
                    </a>

                </div>

            </body>
            </html>
            """);
    }
}