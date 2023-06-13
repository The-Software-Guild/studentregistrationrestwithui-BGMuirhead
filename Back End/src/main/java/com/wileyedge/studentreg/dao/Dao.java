package com.wileyedge.studentreg.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wileyedge.studentreg.model.Student;

@Repository
public class Dao implements IDao {

	private List<Student> students = new ArrayList<>();

//	static {
//		students.add(new Student("John", 20, "1111", "Sydney"));
//		students.add(new Student("Mark", 21, "2222", "Auckland"));
//		students.add(new Student("Steve", 22, "3333", "New York"));
//	}

	@Override
	public Student save(Student s) {
		students.add(s);
		return s;
	}

	@Override
	public List<Student> findAll() {
		return students;
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(int id) {
		return id;
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Optional<Student> findByName(String name) {
//		Student student = students.stream().filter(a -> a.getName().equals(name)).findAny().orElse(null);
//
//		Optional<Student> opt = Optional.ofNullable(student);
//		return opt;
//	}

//	@Override
//	public Student deleteByName(String name)
//
//	{
//		Iterator<Student> iter = students.iterator();
//		while(iter.hasNext()) {
//			Student student = iter.next();
//			if(student.getName().equals(name)) {
//				iter.remove();
//				return student;
//			}
//		}
//		return null;
//	}
//	@Override
//	public Student update(Student stud) {
//		
//		int index = -1;
//		
//		for(int i =0;i<students.size();i++)
//		{
//			if(students.get(i).getName().equals(stud.getName()))
//			{
//				index = i;
//				break;
//			}
//		}
//		if(index==-1)
//		{
//			return null;	
//		}
//		
//		students.set(index, stud);
//		
//		
//		return stud;
//	}

}
