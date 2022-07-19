package com.javaProject.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.javaProject.sm.api.Student;
import com.javaProject.sm.service.StudentService;

@Controller 
public class StudentController {
	
	/**
	@Autowired
	private StudentDAO StudentDAO;
	**/
	
	@Autowired
	private StudentService studentService;
	
	//For Home Page
	@RequestMapping("/home")
	public String showForm()
	{
		return "home";
	}
	
	@RequestMapping(path="/handleForm", method= RequestMethod.POST)
	public String handleForm(@RequestParam("username") String userName, @RequestParam("password") String userPassword)
	{	
		System.out.println(userName);
		if(userName.equals("ABC") && userPassword.equals("ABC123"))
		{
			return "student-list";
		}
		else
		{
			return "error";
		}
	}
	
	
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model)
	{
		//call the service method to get the data from DB
		List<Student> studentList = studentService.loadStudents();
		
		/*
		for(Student tempStudent : studentList)
		{
			System.out.println(tempStudent);
		}
		*/
		
		System.out.println("welcome back to the page");
		model.addAttribute("students", studentList);
		return "student-list";
	} 
	
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model)
	{
		Student student = new Student();
		
		model.addAttribute("student", student);
		return "add-student";
	} 


	@PostMapping("/save-student")
	public String saveStudent(Student student)
	{
		// logic to save the data to the database
		System.out.println(student);
		
		//do a condition check
		//if user doesn't have id -> do insert
		//if user have id -> do update
		
		if(student.getId() == 0)
		{
			studentService.saveStudent(student);
		}
		else
		{
			studentService.update(student);
		}
		
		
		//do a Service call to save the students
		
		//studentService.saveStudent(student);
		
		return "redirect:/showStudent";
	} 
	/***
	@ResponseBody
	@GetMapping("/thankyou")
	public String thankyou()
	{
		return "Thankyou...Your record has been added!!!";
	}
	***/
	
	@GetMapping("/updateStudent")
	//public String updateStudent(@RequestParam("userId") int id,@ModelAttribute("student") Student student)
	public String updateStudent(@RequestParam("userId") int id, Model model)
	{
		/***
		Student myStudent= new Student();
		model.addAttribute("student", myStudent);
		***/
		System.out.println("looking data for the student having id: " + id);
		
		Student theStudent= studentService.getStudent(id);
		System.out.println(theStudent);
		
		/***
		student.setId(theStudent.getId());
		student.setName(theStudent.getName());
		student.setMobile(theStudent.getMobile());
		student.setCountry(theStudent.getCountry());
		***/
		
		model.addAttribute("student", theStudent);
		
		return "add-student";
	} 
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id)
	{
		//capture the id which you want to delete
		//once capture the id, do a service call to delete the student
		
		studentService.deleteStudent(id);
		
		return "redirect:/showStudent";
	} 
}
