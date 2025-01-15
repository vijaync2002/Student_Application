package Com.Student.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Com.Student.Connector.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet Annotation
@WebServlet("/ViewData")
public class ViewData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get connection from ConnectionFactory
            connection = ConnectionFactory.requestConnection();

            // SQL Query to fetch student data (excluding Password)
            String query = "SELECT ID, Name, Phone, MailID, Branch, Location, Date FROM student";
            preparedStatement = connection.prepareStatement(query);

            // Execute query and get results
            resultSet = preparedStatement.executeQuery();

            // Begin HTML output
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>View All Students</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-4'>");
            out.println("<h1 class='text-center mb-4'>Student Data</h1>");
            out.println("<table class='table table-bordered table-hover'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Mail ID</th>");
            out.println("<th>Branch</th>");
            out.println("<th>Location</th>");
            out.println("<th>Date</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            // Populate table rows
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("ID") + "</td>");
                out.println("<td>" + resultSet.getString("Name") + "</td>");
                out.println("<td>" + resultSet.getString("Phone") + "</td>");
                out.println("<td>" + resultSet.getString("MailID") + "</td>");
                out.println("<td>" + resultSet.getString("Branch") + "</td>");
                out.println("<td>" + resultSet.getString("Location") + "</td>");
                out.println("<td>" + resultSet.getTimestamp("Date") + "</td>");
                out.println("</tr>");
            }

            // End HTML output
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println("<h1>Error fetching data!</h1>");
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
    }
}
