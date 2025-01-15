<%@page import="java.sql.*"%>
<%@page import="Com.Student.Connector.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Student Data</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet">
<style>
    /* General Styling */
    body {
        background-color: #e3f2fd;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .navbar {
        background-color: #0d6efd;
        color: white;
    }
    .navbar-brand, .nav-link {
        color: #ffffff !important;
    }
    h1 {
        color: #0d6efd;
        font-size: 2.8rem;
        font-weight: bold;
        margin-bottom: 20px;
    }
    table {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
        overflow: hidden;
    }
    th {
        background-color: #0d6efd;
        color: white;
        text-align: center;
    }
    td {
        text-align: center;
    }
    .highlight {
        background-color: #ffeb3b; /* Highlighted yellow row */
        font-weight: bold;
    }
    footer {
        margin-top: 30px;
        background-color: #0d6efd;
        color: white;
        padding: 15px;
        text-align: center;
    }
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">View Data</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-4">
    <h1 class="text-center mb-4">Student Data</h1>
    <!-- Search Form -->
    <form method="get" action="viewData.jsp" class="d-flex justify-content-center mb-4">
        <%
            String searchId = request.getParameter("id");
            String inputValue = (searchId != null && !searchId.trim().isEmpty()) ? searchId : "";
        %>
        <input type="text" name="id" class="form-control w-50 me-2" placeholder="Enter Student ID" value="<%= inputValue %>">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Mail ID</th>
                    <th>Branch</th>
                    <th>Location</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                <%
                    String highlightId = request.getParameter("id");
                    Connection connection = null;
                    PreparedStatement preparedStatement = null;
                    ResultSet resultSet = null;
                    try {
                        connection = ConnectionFactory.requestConnection();
                        String query = "SELECT ID, Name, Phone, MailID, Branch, Location, Date FROM student";
                        preparedStatement = connection.prepareStatement(query);
                        resultSet = preparedStatement.executeQuery();

                        while (resultSet.next()) {
                            String currentId = String.valueOf(resultSet.getInt("ID"));
                            boolean isHighlighted = highlightId != null && currentId.equals(highlightId.trim());
                            String rowClass = isHighlighted ? "highlight" : "";

                            out.println("<tr class='" + rowClass + "'>");
                            out.println("<td>" + currentId + "</td>");
                            out.println("<td>" + resultSet.getString("Name") + "</td>");
                            out.println("<td>" + resultSet.getString("Phone") + "</td>");
                            out.println("<td>" + resultSet.getString("MailID") + "</td>");
                            out.println("<td>" + resultSet.getString("Branch") + "</td>");
                            out.println("<td>" + resultSet.getString("Location") + "</td>");
                            out.println("<td>" + resultSet.getTimestamp("Date") + "</td>");
                            out.println("</tr>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (resultSet != null) resultSet.close();
                            if (preparedStatement != null) preparedStatement.close();
                            if (connection != null) connection.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<footer>
    © 2024 Student Management System | <a href="#">Terms of Use</a> | <a href="#">Privacy Policy</a>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
