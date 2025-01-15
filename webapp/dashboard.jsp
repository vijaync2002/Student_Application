<%@page import="Com.Student.DTO.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet">
<style>
    /* General Body Styling */
    body {
        background-color: #e3f2fd; /* Light blue background */
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    /* Navbar Styling */
    .navbar-brand {
        font-size: 1.8rem;
        font-weight: bold;
        color: #ffffff !important; /* Keep consistent with navbar */
    }

    .navbar {
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2); /* Enhance shadow */
        background-color: #0d6efd; /* Bootstrap primary color */
    }

    .nav-link {
        color: #ffffff !important;
        font-size: 1.1rem;
    }

    .btn-danger {
        border: none;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    .btn-danger:hover {
        background-color: #b02a37;
        transform: scale(1.05); /* Slightly enlarge on hover */
    }

    /* Header Section Styling */
    h1 {
        color: #0d6efd; /* Match primary color */
        font-size: 2.8rem;
        font-weight: bold;
        margin-bottom: 20px;
    }

    h3 {
        color: #495057;
        font-weight: bold;
        margin-bottom: 20px;
    }

    /* Table Styling */
    table {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2); /* Add more depth */
        overflow: hidden;
    }

    th {
        background-color: #0d6efd;
        color: white;
        text-align: center;
        font-size: 1rem;
        padding: 15px;
    }

    td {
        text-align: center;
        font-size: 0.95rem;
        padding: 10px;
    }

    .table-hover tbody tr:hover {
        background-color: #e3f2fd; /* Match body background */
        transition: background-color 0.3s ease;
    }

    /* Footer Section */
    footer {
        margin-top: 290px;
        background-color: #0d6efd;
        color: white;
        padding: 15px;
        text-align: center;
        font-size: 0.9rem;
    }

    footer a {
        color: #ffffff;
        text-decoration: underline;
    }

    footer a:hover {
        text-decoration: none;
    }
</style>
</head>
<body>

<%Student s=(Student)session.getAttribute("student"); %>    <!-- session get -->  
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
    
        <a class="navbar-brand" href="#">Welcome <%if(s.getId()==1) {%>Admin: <%}%><%=s.getName() %></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
            <%if(s.getId()==1){ %>
            
                <li class="nav-item">
                    <a class="nav-link" href="viewData.jsp?id=<%= s.getId() %>">View Data</a> 
                </li>
                <%} %>
                <li class="nav-item">
                    <a class="nav-link" href="forgotPin.jsp">Reset Password</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="updateAccount.jsp">Update Data</a>
                </li>
                <li class="nav-item">
                <form action="Logout" method="post">
                <input class="btn btn-danger nav-link text-white" type="submit" name="logout" value="Logout">
                
                </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-4">
    <h1 class="text-center mb-4">Dashboard</h1>
</div>
<!-- User Section -->
<div class="row">
    <div class="col-md-12">
        <h3>View Your Data</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Mail ID</th>
                <th>Branch</th>
                <th>Location</th>
            </tr>
            </thead>
            <tbody>
            <!-- Table data goes here -->
            <tr>
            <td><%=s.getId() %></td>
            <td><%=s.getName() %></td>
            <td><%=s.getPhone() %></td>
            <td><%=s.getMail() %></td>
            <td><%=s.getBranch() %></td>
            <td><%=s.getLocation() %></td>
            </tr>
           
            </tbody>
        </table>
    </div>
</div>
<footer>
    © 2024 Student Management System | <a href="#">Terms of Use</a> | <a href="#">Privacy Policy</a>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
