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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login") 
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//collect the data from the user  
		  String mail=req.getParameter("mail"); 
		  String password=req.getParameter("password"); 
		  PrintWriter out=resp.getWriter(); 
		  
		  HttpSession session=req.getSession();                                 // session created
		   
		  //jdbc implementation 
		  StudentDAO sdao=new StudentDAOImpl(); 
		  Student s1=sdao.getStudent(mail, password); 
		  if(s1!=null) { 
			   session.setAttribute("student", s1);                              // session implemented
			   RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			   rd.forward(req, resp);
			  
//	       resp.sendRedirect("success.html");
//		   out.println("<h1>Login successful, Welcome "+s.getName()+"</h1>" 
//		     + "<br>" 
//		     + "<a href=\"login.html\">Back</a>"); 
		  } 
		  else{ 
			   req.setAttribute("failure", "failed to login!");
			   RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			   rd.forward(req, resp);
			  
//			  resp.sendRedirect("failure.html");
//		   out.println("<h1>Invalid mail or password!</h1>"  + "<br>" + "<a href=\"login.html\">Back</a>"); 
		  }   
	} 
}
