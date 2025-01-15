package Com.Student.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import Com.Student.DAO.StudentDAO;
import Com.Student.DAO.StudentDAOImpl;
import Com.Student.DTO.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup") 

public class Signup extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
			//collect the data from user
			String name=req.getParameter("name"); 
			String phonenumber=req.getParameter("phone"); 
			String mailId=req.getParameter("mail"); 
			String branch=req.getParameter("branch"); 
			String loc=req.getParameter("loc"); 
			String password=req.getParameter("password"); 
			String confirmPassword=req.getParameter("confirm");
			
			//converting the necessary datatypes
			 long phone=Long.parseLong(phonenumber); 
			PrintWriter out=resp.getWriter(); 
			
			//JDBC Implementation
			Student s=new Student();  
			StudentDAO sdao=new StudentDAOImpl();
			if(password.equals(confirmPassword)) {
				s.setName(name); 
				   s.setPhone(phone); 
				   s.setMail(mailId); 
				   s.setBranch(branch); 
				   s.setLocation(loc); 
				   s.setPass(password); 
				   boolean result=sdao.insertStudent(s); 
				   if(result){ 
				    
					   
					   
					   req.setAttribute("success", "signup successful");
					   RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
					   rd.forward(req, resp);
					   
				   } 
				   else{ 
					   
					   req.setAttribute("failure", "failed to signup");
					   RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
					   rd.forward(req, resp);

				   } 
				  }  
				 }
			}

