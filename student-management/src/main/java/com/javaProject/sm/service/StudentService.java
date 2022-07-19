package com.javaProject.sm.service;

import java.util.List;

import com.javaProject.sm.api.Student;

public interface StudentService {
	
	List<Student> loadStudents();
	void saveStudent(Student student);
	
	Student getStudent(int id);
	void update(Student student);
	
	void deleteStudent(int id);

}
