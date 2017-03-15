package com.spring.angular.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.rest.model.Student;
import com.spring.angular.rest.model.User;
import com.spring.angular.rest.service.StudentService;

@RestController
public class UserController {
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	ResponseEntity<List<Student>> getUsers() {
		List<Student> students = studentservice.allStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@RequestMapping(value="/addStudents",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> addUser(@RequestBody Student student){
		
		System.out.println("Post Service Running");
		System.out.println(student);
		studentservice.saveStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteStudent/{roll}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("roll") int roll){
		
		System.out.println("indelete");
		studentservice.deleteStudent(roll);
		return new ResponseEntity<Student>(new Student(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteStudent1/{roll}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity <User> deleteStudent1(@PathVariable("roll") int roll)
	{
		
		System.out.println("in  delete student");
		studentservice.deleteStudent(roll);
		return new ResponseEntity<User>(new User("vv", "hv", "yfyf", "tdd"),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getStudent1/{roll}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity <Student> getStudent1(@PathVariable("roll") int roll)
	{
		
		System.out.println("in  get student");
		Student student=studentservice.getStudent(roll);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student){
		
		System.out.println("Post Service Running");
		System.out.println(student);
		studentservice.updateStudent(student);
		List<Student> students = studentservice.allStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	

}
