package com.wileyedge.studentreg.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wileyedge.studentreg.model.Student;

public interface IDao {
	
	//POST
	Student save(Student s);
	//GET GENERIC

	List<Student> findAll();
	//GET SPECIFIC
	Optional<Student> findById(int id);
	//DELETE specific
	int deleteById(int id);
	//PUT SPECIFIC
//	@Transactional
//	@Modifying
//	@Query("update Student s set s.name = stud.getName(), s.age= stud.getAge(), s.mobile = stud.getMobile(),s.address = stud.getAddress() where s.id = stud.getId()")
//	int updateStudent(Student stud);
	
//	@Modifying
//	Student update(Student stud);
	

}
