package Com.Student.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Com.Student.DTO.Student;
import Com.Student.Connector.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {

	private Connection con;
	
	public  StudentDAOImpl() {
		this.con=ConnectionFactory.requestConnection();
		if (this.con == null) {
	        throw new RuntimeException("Failed to establish database connection.");
	    }
	}
	
	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		
		String query ="insert into student values (0,?,?,?,?,?,?,sysdate())";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPass());
			res=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(res>0) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		String query="UPDATE STUDENT SET PASSWORD=? WHERE ID=?"; 
		  int res=0; 
		  PreparedStatement ps=null; 
		  try { 
			  ps=con.prepareStatement(query); 
			   //ps.setString(1,s.getName()); 
			   ps.setString(1,s.getPass()); 
			   ps.setInt(2, s.getId()); 
			   //ps.setString(4, s.getBranch()); 
			   //ps.setInt(5, s.getLid()); 
			   //ps.setString(6, s.getPass()); 
			   res=ps.executeUpdate(); 
			  } catch (SQLException e) { 
			   // TODO Auto-generated catch block 
			   e.printStackTrace(); 
			  } 
			  if(res>0) 
			  { 
			   return true; 
			  } 
			  else 
			  { 
			   return false; 
			  } 
		  
	}
	
	@Override
	public boolean updateStudentAcc(Student s) {
	    String query = "UPDATE STUDENT SET NAME = ?, PHONE = ?, MAILID = ?, BRANCH = ?, LOCATION = ? WHERE ID = ?";
	    try (PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setString(1, s.getName());
	        ps.setLong(2, s.getPhone());
	        ps.setString(3, s.getMail());
	        ps.setString(4, s.getBranch());
	        ps.setString(5, s.getLocation());
	        ps.setInt(6, s.getId());

	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}



	
//	public boolean updateStudent(Student s) {
//	    String query = "UPDATE STUDENT SET PASSWORD = ? WHERE PHONE = ? AND MAILID = ?";
//	    int res = 0;
//	    PreparedStatement ps = null;
//	    try {
//	        ps = con.prepareStatement(query);
//	        ps.setString(1, s.getPass()); // Set new password
//	        ps.setLong(2, s.getPhone()); // Match phone number
//	        ps.setString(3, s.getMail()); // Match email
//	        res = ps.executeUpdate();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    System.out.println(res);
//	    return res > 0; // Return true if the update was successful
//	}


	@Override
	public boolean deleteStudent(Student s) {
		// TODO Auto-generated method stub
		String query="DELETE FROM STUDENT WHERE ID=?"; 
		  int res=0; 
		  PreparedStatement ps=null; 
		  try {
			  ps=con.prepareStatement(query); 
			   ps.setInt(1,s.getId()); 
			   //ps.setLong(2,s.getPhone()); 
			   //ps.setString(3, s.getMail()); 
			   //ps.setString(4, s.getBranch()); 
			   //ps.setInt(5, s.getLid()); 
			   //ps.setString(6, s.getPass()); 
			   res=ps.executeUpdate(); 
		  } catch (SQLException e) { 
			   // TODO Auto-generated catch block 
			   e.printStackTrace(); 
			  } 
			  if(res>0) 
			  { 
			   return true; 
			  }else { 
		return false;
			  }
	}

	@Override
	public Student getStudent(String mail, String pass) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM STUDENT WHERE MAILID=? AND PASSWORD=?"; 
		    Student s=null; 
			PreparedStatement ps=null; 
		    ResultSet rs=null;
		    try { 
		    	   ps=con.prepareStatement(query); 
		    	   ps.setString(1, mail); 
		    	   ps.setString(2, pass); 
		    	   rs=ps.executeQuery(); 
		    	   while(rs.next()) 
		    	   { 
		    	    s=new Student(); 
		    	    //String name=rs.getString("name"); 
		    	 
		    	    //s.setName(name); 
		    	    s.setId(rs.getInt("id")); 
		    	    s.setName(rs.getString("name")); 
		    	    s.setPhone(rs.getLong("phone")); 
		    	    s.setMail(rs.getString("mailid")); 
		    	    s.setBranch(rs.getString("branch")); 
		    	    s.setLocation(rs.getString("location")); 
		    	    s.setPass(rs.getString("password")); 
		    	    s.setDate(rs.getString("date")); 
		    	   } 
		    	  } catch (SQLException e) { 
		    	   e.printStackTrace(); 
		    	  } 
		    	  return s; 
		    	 } 

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> students=new ArrayList<Student>(); 
		  Student s=null; 
		  String query="SELECT * FROM STUDENT"; 
		 
		  PreparedStatement ps=null; 
		  ResultSet rs=null;  
		  try { 
		   ps=con.prepareStatement(query); 
		   rs=ps.executeQuery(); 
		   while(rs.next()){ 
		    s=new Student(); 
		    //String name=rs.getString("name"); 
		    //s.setName(name); 
		    s.setId(rs.getInt("id")); 
		    s.setName(rs.getString("name")); 
		    s.setPhone(rs.getLong("phone")); 
		    s.setMail(rs.getString("mailid")); 
		    s.setBranch(rs.getString("branch")); 
		    s.setLocation(rs.getString("location")); 
		    s.setPass(rs.getString("password")); 
		    s.setDate(rs.getString("date")); 
		    students.add(s); 
		   } 
		  } catch (SQLException e) { 
			  e.printStackTrace(); 
		  } 
		  return students; 
	}

    @Override
//	public Student getStudent(long phone, String mail) {
//
//		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?"; 
//			Student s=null; 
//			PreparedStatement ps=null; 
//			ResultSet rs=null; 
//			try { 
//				ps=con.prepareStatement(query); 
//				ps.setLong(1, phone);
//				ps.setString(2, mail); 
//				rs=ps.executeQuery(); 
//				while(rs.next()){ 
//				    s=new Student(); 
//				    //String name=rs.getString("name"); 
//				    //s.setName(name); 
//				    s.setId(rs.getInt("id")); 
//				    s.setName(rs.getString("name")); 
//				    s.setPhone(rs.getLong("phone")); 
//				    s.setMail(rs.getString("mail")); 
//				    s.setBranch(rs.getString("branch")); 
//				    s.setLocation(rs.getString("location")); 
//				    s.setPass(rs.getString("password")); 
//				    s.setDate(rs.getString("date")); 
//				} 
//			} catch (SQLException e) { 
//				e.printStackTrace(); 
//			} 
//				return s; 
//	}
    
    public Student getStudent(long phone, String mail) {
        // Correct query with the proper column name
        String query = "SELECT * FROM STUDENT WHERE PHONE=? AND MAILID=?";
        Student s = null; 
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        
        try { 
            ps = con.prepareStatement(query); 
            ps.setLong(1, phone); // Bind the phone parameter
            ps.setString(2, mail); // Bind the email parameter
            rs = ps.executeQuery(); 
            
            if (rs.next()) { // Use if instead of while since only one record is expected
                s = new Student(); 
                s.setId(rs.getInt("id")); 
                s.setName(rs.getString("name")); 
                s.setPhone(rs.getLong("phone")); 
                s.setMail(rs.getString("mail")); 
                s.setBranch(rs.getString("branch")); 
                s.setLocation(rs.getString("location")); 
                s.setPass(rs.getString("password")); 
                s.setDate(rs.getString("date")); 
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return s; 
    }

	
} 
		  

