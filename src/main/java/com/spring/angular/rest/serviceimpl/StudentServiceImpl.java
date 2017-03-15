package com.spring.angular.rest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.angular.rest.dao.StudentDao;
import com.spring.angular.rest.model.Student;
import com.spring.angular.rest.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	public Student getStudent(int roll) {
		return studentDao.getStudent(roll);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.updateStudent(student);
	}

	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		return studentDao.allStudents();
	}

	public void deleteStudent(int roll) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(roll);
	}

}
