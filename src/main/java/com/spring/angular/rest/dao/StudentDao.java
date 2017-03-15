package com.spring.angular.rest.dao;

import java.util.List;

import com.spring.angular.rest.model.Student;

public interface StudentDao {
	public void saveStudent(Student student);
	public Student getStudent(int roll);
	public void updateStudent(Student student);
	public List<Student> allStudents();
	public void deleteStudent(int roll);

}
