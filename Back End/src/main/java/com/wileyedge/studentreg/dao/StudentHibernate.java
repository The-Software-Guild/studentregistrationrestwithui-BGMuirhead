package com.wileyedge.studentreg.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.wileyedge.studentreg.exception.UserNotFoundException;
import com.wileyedge.studentreg.model.Student;

@Repository(value = "hRepo")
public class StudentHibernate implements IDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public Student save(Student s) {
		System.out.println("Inside save of sHibernate");
		em.merge(s);

		if (s.getId() != 0) {
			return s;
		}
//		String sql = "Select MAX(s.id) FROM Student s";
		int id = (int) em.createQuery("select max(s.id) from Student s").getSingleResult();

		s.setId(id);
		return s;
	}

	@Override
	public List<Student> findAll() {
		System.out.println("Inside findAll of sHibernate");

		@SuppressWarnings("unchecked")
		List<Student> studs = em.createQuery("SELECT s FROM Student s").getResultList();

		return studs;
	}

	@Override
	public Optional<Student> findById(int id) {
		Student s =null;
		try {
			s = (Student) em.createQuery("select s from Student s where s.id=?1").setParameter(1, id)
					.getSingleResult();
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("User with id: "+id+" not found"); 
		}
		

		
		return Optional.ofNullable(s);
	}

	@Override
	@Transactional
	public int deleteById(int id) {
		Query q = em.createQuery("Delete from Student s where s.id=?1").setParameter(1, id);
		int i = q.executeUpdate();
		
		return i;
	}

//	@Transactional
//	public Student updateStudent(Student stud) {
//		System.out.println("Inside save of UserHibernateWithJPARepository:" + em);
//
//		em.merge(stud);
//
//		return stud;
//	}

}
