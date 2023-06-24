package com.springjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjdbc.api.Student;
import com.springjdbc.dao.StudentDAOImpl;

@Service("studentDaoHelper")
public class StudentDAOHelper {
	
	@Autowired
	StudentDAOImpl studentDAOImpl;
	
	public void setUpStudentTable() {
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Steve");
		s1.setAge(30); 
		s1.setAddress("Bangalore");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Clarke");
		s2.setAge(23);
		s2.setAddress("Kolkata");
		
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Diana");
		s3.setAge(19);
		s3.setAddress("Chennai");
		
		Student s4 = new Student();
		s4.setId(4);
		s4.setName("Akshay");
		s4.setAge(22);
		s4.setAddress("Bangalore");
		
		Student s5 = new Student();
		s5.setId(5);
		s5.setName("Ujjwal");
		s5.setAge(25);
		s5.setAddress("Kolkata");
		
		Student s6 = new Student();
		s6.setId(6);
		s6.setName("Sameer");
		s6.setAge(30);
		s6.setAddress("Delhi");
		
		Student s7 = new Student();
		s7.setId(7);
		s7.setName("Ajay");
		s7.setAge(47);
		s7.setAddress("Punjab");
		
		List<Student> studentsList = new ArrayList<>();
		studentsList.add(s1);
		studentsList.add(s2);
		studentsList.add(s3);
		studentsList.add(s4);
		studentsList.add(s5);
		studentsList.add(s6);
		studentsList.add(s7);
		
		studentDAOImpl.insertMultiple(studentsList);
	}
	
	// printAllStudents
	public void printAllStudents(List<Student> studentsList) {
		for(Student s : studentsList) {
			System.out.println(s);
		}
	}

}
