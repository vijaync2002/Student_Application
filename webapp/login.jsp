<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pentagon Space - Login</title>
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
        input[type="email"], input[type="password"] {
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
            text-decoration: none;
            color: #1e90ff;
            font-size: 1em;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="heading">Pentagon Space</h1>
        <h3 class="sub">Login</h3>
        
        <%String success=(String)request.getAttribute("success");
        if(success !=null){%>
        <h3 class="success"><%=success%></h3>
        <%} %>
        
        <%String failure=(String)request.getAttribute("failure");
        if(failure !=null){%>
        <h3 class="failure"><%=failure%></h3>
        <%} %>
        
        <form action="login" method="post">
            <table>
                <tr>
                    <td><label for="mail"><b>Enter Your Email:</b></label></td>
                    <td><input type="email" id="mail" name="mail" placeholder="Enter email" required></td>
                </tr>
                <tr>
                    <td><label for="password"><b>Enter Your Password:</b></label></td>
                    <td><input type="password" id="password" name="password" placeholder="Enter password" required></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"></td>
                    <td><a href="forgotPin.jsp">Forgot Password?</a></td>
                </tr>
            </table>
            <p>Don't have an account? <a href="Signup.jsp">Signup</a></p>
        </form>
    </div>
</body>
</html>