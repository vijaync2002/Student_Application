<%@ page import="Com.Student.DTO.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Body Styling */
        body {
            background-color: #e3f2fd; /* Consistent light blue background */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        /* Navbar Styling */
        .navbar-brand {
            font-size: 1.8rem;
            font-weight: bold;
            color: #ffffff !important;
        }

        .navbar {
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            background-color: #0d6efd;
        }

        .nav-link {
            color: #ffffff !important;
            font-size: 1.1rem;
        }

        /* Container Styling */
        .container {
            background-color: #ffffff;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            padding: 2rem;
            margin-top: 2rem;
        }

        h1 {
            font-weight: bold;
            color: #0d6efd;
            margin-bottom: 20px;
        }

        label {
            font-weight: 500;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }

        /* Footer Styling */
        footer {
            margin-top: 30px;
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

<% 
    Student s = (Student) session.getAttribute("student");
    if (s == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Update Account</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="text-center mb-4">Update Account</h1>
    <form action="UpdateAccount" method="post">
        <!-- Hidden field to include the ID -->
        <input type="hidden" name="id" value="<%= s.getId() %>">

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= s.getName() %>" required>
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" value="<%= s.getPhone() %>" required>
        </div>

        <div class="mb-3">
            <label for="mail" class="form-label">Mail ID</label>
            <input type="email" class="form-control" id="mail" name="mail" value="<%= s.getMail() %>" required>
        </div>

        <div class="mb-3">
            <label for="branch" class="form-label">Branch</label>
            <input type="text" class="form-control" id="branch" name="branch" value="<%= s.getBranch() %>" required>
        </div>

        <div class="mb-3">
            <label for="location" class="form-label">Location</label>
            <input type="text" class="form-control" id="location" name="location" value="<%= s.getLocation() %>" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Update</button>
    </form>
</div>

<footer>
    © 2024 Student Management System | <a href="#">Terms of Use</a> | <a href="#">Privacy Policy</a>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
