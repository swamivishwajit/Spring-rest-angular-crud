package com.spring.angular.rest.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.angular.rest.dao.StudentDao;
import com.spring.angular.rest.model.Student;

public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory factory;
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.save(student);
		session.beginTransaction().commit();
		session.close();
		System.out.println("In Dao:"+student);
	}

	public Student getStudent(int roll) {
		Session session=factory.openSession();
		Query query=session.createQuery("from Student where roll=?");
		query.setParameter(0, roll);
		Student student=(Student)query.uniqueResult();
		session.beginTransaction().commit();
		session.close();
		return student;
		
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.update(student);
		session.beginTransaction().commit();
		session.close();
		System.out.println("In Dao:"+student);
		
	}

	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		Query query=session.createQuery("from Student");
		@SuppressWarnings("unchecked")
		List<Student> students=query.list();
		session.beginTransaction().commit();
		session.close();
		return students;
	}

	public void deleteStudent(int roll) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Query query=session.createQuery("delete from Student where roll=?");
		query.setParameter(0, roll);
		query.executeUpdate();
		
		session.beginTransaction().commit();
		session.close();
	}

}
