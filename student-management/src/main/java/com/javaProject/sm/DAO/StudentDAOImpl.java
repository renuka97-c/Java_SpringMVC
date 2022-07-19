package com.javaProject.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaProject.sm.api.Student;
import com.javaProject.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() 
	{
		// TODO Auto-generated method stub
		
		//List<Student> studentList = new ArrayList<Student>();
		
		String sql = "SELECT * FROM students";
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return theListOfStudent;
	}
	@Override
	public void saveStudent(Student student) 
	{
		//logic to store the student object into the database
		Object[] sqlParameters= {student.getName(), student.getMobile(), student.getCountry()};
		
		String sql = "insert into students(name, mobile, country) values(?,?,?)";
		jdbcTemplate.update(sql, sqlParameters);
		
		System.out.println("Record Updated...");
	}

	@Override
	public Student getStudent(int id) 
	{
		String sql= "SELECT * FROM STUDENTS WHERE ID = ?";
		Student student= jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	
	@Override
	public void update(Student student) 
	{
		String sql = "UPDATE STUDENTS SET name = ?, mobile = ?, country= ? WHERE id = ?";
		jdbcTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(), student.getId());
		System.out.println("1 Record Updated....");
	}

	@Override
	public void deleteStudent(int id) 
	{
		String sql = "DELETE FROM STUDENTS WHERE ID= ?";
		jdbcTemplate.update(sql, id);
		System.out.println("Record DEleted");
		
	}
	
}
