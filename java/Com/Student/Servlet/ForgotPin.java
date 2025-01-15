package Com.Student.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import Com.Student.DAO.StudentDAO;
import Com.Student.DAO.StudentDAOImpl;
import Com.Student.DTO.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/forgotPin")
//public class ForgotPin extends HttpServlet {
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		//collect the data from user 
//		  String phonenumber=req.getParameter("phone"); 
//		  String mail=req.getParameter("mail"); 
//		  String password=req.getParameter("password"); 
//		  String confirmPassword=req.getParameter("confirm"); 
//		   
//		  //conversion of datatypes 
//		  long phone=Long.parseLong(phonenumber); 
//		  PrintWriter out=resp.getWriter(); 
//		   
//		  //JDBC Implementation 
//		  StudentDAO sdao=new StudentDAOImpl(); 
//		  Student s1= sdao.getStudent(phone, mail); 
//		  if(s1!=null&&password.equals(confirmPassword)) 
//		  { 
//		   s1.setPass(confirmPassword); 
//		   boolean result=sdao.updateStudent(s1); 
//		   if(result) 
//		   { 
//		    out.println("<h1>Password updated successfully</h1>"); 
//		   }else {
//			   out.println("<h1>Failed to update the  password</h1>"); 
//		   }
//	  }
//	
//  }
//}

@WebServlet("/forgotPin")
public class ForgotPin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Collect data from the user
        String phonenumber = req.getParameter("phone");
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm");

        PrintWriter out = resp.getWriter();

        // Validate input and passwords
        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            out.println("<h1>Passwords do not match!</h1>");
            return;
        }

        // Conversion of data types
        long phone;
        try {
            phone = Long.parseLong(phonenumber);
        } catch (NumberFormatException e) {
            out.println("<h1>Invalid phone number!</h1>");
            return;
        }

        // JDBC Implementation
        StudentDAO sdao = new StudentDAOImpl();
        Student s1 = sdao.getStudent(phone, mail); // Fetch existing student details
//        if (s1 != null) {
//            s1.setPass(password); // Update password in the Student object
//            boolean result = sdao.updateStudent(s1);
//            if (result) {
//                out.println("<h1>Password updated successfully</h1>");
//            } else {
//                out.println("<h1>Failed to update the password</h1>");
//            } 
//        } else {
//            out.println("<h1>Student not found!</h1>");
//        }
        
        if (s1 == null) {
            out.println("<h1>Student not found!</h1>");
            System.out.println("No student found for phone: " + phone + " and email: " + mail);
        } else if (!password.equals(confirmPassword)) {
            out.println("<h1>Passwords do not match!</h1>");
        } else {
            s1.setPass(password);
            boolean result = sdao.updateStudent(s1);
            if (result) {
                out.println("<h1>Password updated successfully</h1>");
            } else {
                out.println("<h1>Failed to update the password</h1>");
            }
        }

    }
}

