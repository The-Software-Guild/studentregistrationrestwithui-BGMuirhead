package com.wileyedge.studentreg.service;

import java.util.List;

import com.wileyedge.studentreg.model.Student;

public interface IService {

	List<Student> retrieveAllStudents();

	Student findStudent(int id);

	Student save(Student student);

	int deleteStudent(int id);
	
	Student updateStudent(Student s);
}
