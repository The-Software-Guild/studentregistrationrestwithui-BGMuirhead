package com.wileyedge.studentreg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wileyedge.studentreg.exception.UserNotFoundException;
import com.wileyedge.studentreg.model.Student;
import com.wileyedge.studentreg.service.IService;


@RestController
@CrossOrigin(origins = "*")
public class Controller {

	
	@Autowired
	IService service;

	@GetMapping(path = "/students")
	public List<Student> fetchAllStudents()
	{
		
		System.out.println("Inside fetchAllUsers of Controller");
		List<Student> students = service.retrieveAllStudents();
		return students;
		
	}
	
	@RequestMapping(value = "/students/{id}" , method = RequestMethod.GET)
	public Student fetchStudent(@PathVariable int id)
	{
		System.out.println("Inside fetchStudent of Controller");
		Student s = service.findStudent(id);
		if(s==null)
		{
			throw new UserNotFoundException("User with id: "+id+" not found");
		}
		return s;
	}

	
	@PostMapping(path = "/students" , consumes = "application/json")
	public Student createUser(@Valid @RequestBody Student student)
	{
		System.out.println("Inside createUser of Controller");
		Student s = service.save(student);
		return s;
	}
	
	@PutMapping(path = "/students" , consumes = "application/json")
	public Student updateStudent(@Valid @RequestBody Student student)
	{
		System.out.println("Inside updateStudent of Controller");
		Student s = service.updateStudent(student);
		if(s==null)
		{
			throw new UserNotFoundException("User with id: "+student.getId()+" not found");
		}
		return s;
	}
	
	@RequestMapping(value = "/students/{id}" , method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int id)
	{
		System.out.println("Inside deleteStudent of Controller");
		
		
			int i =service.deleteStudent(id);
			if(i==0)
			{
				throw new UserNotFoundException("User with id: "+id+" not found");
			}
		
		
		System.out.println("Student Deleted");
	}
}
