package com.spring.angular.rest.service;

import java.util.List;

import com.spring.angular.rest.model.Student;
import com.spring.angular.rest.model.User;

public interface StudentService {
	public void saveStudent(Student student);
	public Student getStudent(int roll);
	public void updateStudent(Student student);
	public List<Student> allStudents();
	public void deleteStudent(int roll);
	

}
