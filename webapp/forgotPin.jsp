<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pentagon Space - Password Update</title>
    <style>
        body {
            background-color: #b2dbff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            padding: 50px 20px;
        }
        .heading {
            color: #000080;
            font-size: 2.5em;
            margin-bottom: 10px;
        }
        .sub {
            color: #1e90ff;
            font-size: 1.2em;
            margin-bottom: 30px;
        }
        form {
            display: inline-block;
            background: #e0e0e0;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        table {
            width: 100%;
        }
        td {
            padding: 10px 5px;
        }
        input[type="tel"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1em;
        }
        input[type="submit"] {
            background-color: #1e90ff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            display: inline-block;
            text-decoration: none;
            color: #1e90ff;
            font-size: 1em;
            margin-top: 10px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="heading">Pentagon Space</h1>
        <h3 class="sub">Update Your Password Here</h3>
        <form action="forgotPin" method="post">
            <table>
                <tr>
                    <td><label for="phone"><b>Enter Your Phone Number:</b></label></td>
                    <td><input type="tel" id="phone" name="phone" placeholder="Enter phone number" required></td>
                </tr>
                <tr>
                    <td><label for="mail"><b>Enter Your Email:</b></label></td>
                    <td><input type="email" id="mail" name="mail" placeholder="Enter email" required></td>
                </tr>
                <tr>
                    <td><label for="password"><b>Enter a New Password:</b></label></td>
                    <td><input type="password" id="password" name="password" placeholder="Enter new password" required></td>
                </tr>
                <tr>
                    <td><label for="confirm"><b>Confirm Your Password:</b></label></td>
                    <td><input type="password" id="confirm" name="confirm" placeholder="Confirm new password" required></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update Pin"></td>
                    <td><a href="login.jsp">Back</a></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
