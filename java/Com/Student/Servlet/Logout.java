package Com.Student.Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String logs=req.getParameter("logout"); 
	HttpSession s=req.getSession(false); 
	while(logs.equals("Logout")) { 
	s.invalidate(); 
	req.setAttribute("success","Logged out successfully"); 
	RequestDispatcher rd=req.getRequestDispatcher("login.jsp");  
	rd.forward(req, resp); 
	} 
	} 
} 