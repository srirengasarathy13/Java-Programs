<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>

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
            background: white;
            width: 400px;
            padding: 35px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
        }

        h1 {
            color: #222;
            margin-bottom: 10px;
        }

        p {
            color: #666;
            margin-bottom: 25px;
        }

        .button {
            display: inline-block;
            padding: 12px 25px;
            background: #2563eb;
            color: white;
            text-decoration: none;
            border-radius: 8px;
        }

        .button:hover {
            background: #1d4ed8;
        }
    </style>
</head>

<body>

    <div class="card">

        <h1>Employee Management</h1>

        <p>Welcome to the Employee Portal</p>

        <a href="employee" class="button">
            View Employee Details
        </a>

    </div>

</body>
</html>