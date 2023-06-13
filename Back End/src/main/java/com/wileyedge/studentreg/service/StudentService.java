package com.wileyedge.studentreg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.studentreg.dao.IDao;
import com.wileyedge.studentreg.model.Student;

@Service
public class StudentService implements IService {

	@Autowired
//	@Qualifier(value = "jpaRepository") this one was partially working
	@Qualifier(value = "hRepo")
	private IDao dao; // without qualifier - uses memory

	@Override
	public List<Student> retrieveAllStudents() {
		System.out.println("Inside retrieveAllStudents of StudentService");
		List<Student> users = dao.findAll();
		return users;
	}

	@Override
	public Student findStudent(int id)
	{

		System.out.println("Inside findStudent of StudentService");

		Optional<Student> opt = dao.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	@Override
	public Student save(Student student) {

		System.out.println("Inside save of StudentService");
		Student s = dao.save(student);
		return s;

	}

	@Override
	public int deleteStudent(int id) {

		System.out.println("Inside deleteStudent of StudentService");
		return dao.deleteById(id);
	}

	@Override
	public Student updateStudent(Student s) {
		System.out.println("Inside updateStudent of StudentService");
//		return dao.updateStudent(s) ==1 ? s : null;
//		return dao.updateStudent(s);
		return dao.save(s);
	}

}
