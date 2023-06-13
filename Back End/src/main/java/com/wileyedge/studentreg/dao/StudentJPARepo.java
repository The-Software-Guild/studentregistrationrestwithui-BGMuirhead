package com.wileyedge.studentreg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wileyedge.studentreg.model.Student;
@Repository(value = "jpaRepository")
public interface StudentJPARepo extends IDao, JpaRepository<Student, Integer> {

	
	
}
