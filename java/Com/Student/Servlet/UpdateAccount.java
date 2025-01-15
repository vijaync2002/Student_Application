package Com.Student.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Com.Student.Connector.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet Annotation
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    PrintWriter out = resp.getWriter();
	    resp.setContentType("text/html");

	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        // Validate and parse input parameters
	        String idParam = req.getParameter("id");
	        String name = req.getParameter("name");
	        String phoneParam = req.getParameter("phone");
	        String mail = req.getParameter("mail");
	        String branch = req.getParameter("branch");
	        String location = req.getParameter("location");

	        if (idParam == null || idParam.isEmpty() || 
	            name == null || name.isEmpty() || 
	            phoneParam == null || phoneParam.isEmpty() || 
	            mail == null || mail.isEmpty() || 
	            branch == null || branch.isEmpty() || 
	            location == null || location.isEmpty()) {

	            out.println("<h1>Error: Missing or empty input parameters!</h1>");
	            return;
	        }

	        int id = Integer.parseInt(idParam);
	        long phone = Long.parseLong(phoneParam);

	        // Log inputs for debugging
	        System.out.println("ID: " + id);
	        System.out.println("Name: " + name);
	        System.out.println("Phone: " + phone);
	        System.out.println("Mail: " + mail);
	        System.out.println("Branch: " + branch);
	        System.out.println("Location: " + location);

	        // Establish connection and update the student record
	        connection = ConnectionFactory.requestConnection();
	        String query = "UPDATE student SET Name = ?, Phone = ?, MailID = ?, Branch = ?, Location = ? WHERE ID = ?";
	        preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setString(1, name);
	        preparedStatement.setLong(2, phone);
	        preparedStatement.setString(3, mail);
	        preparedStatement.setString(4, branch);
	        preparedStatement.setString(5, location);
	        preparedStatement.setInt(6, id);

	        int rowsUpdated = preparedStatement.executeUpdate();

	        if (rowsUpdated > 0) {
	            out.println("<h1 class='text-center text-success'>Account updated successfully!</h1>");
	        } else {
	            out.println("<h1 class='text-center text-danger'>Failed to update account. ID not found.</h1>");
	        }
	    } catch (Exception e) {
	        out.println("<h1>Error updating account: " + e.getMessage() + "</h1>");
	        e.printStackTrace();
	    } finally {
	        try {
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}