package Com.Student.DAO;

import java.util.List;

import Com.Student.DTO.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean updateStudentAcc(Student s);

	public boolean deleteStudent(Student s);
	public Student getStudent(String mail, String pass);
	public Student getStudent(long phone, String mail);
	public List<Student> getStudent();
   
}