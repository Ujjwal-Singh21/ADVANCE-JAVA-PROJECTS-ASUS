package com.springjdbc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.api.Student;
import com.springjdbc.dao.StudentDAOImpl;
import com.springjdbc.service.StudentDAOHelper;

public class RunnerClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application context loaded");

		// INSERT MULTIPLE
		StudentDAOHelper studentDAOHelper = context.getBean("studentDaoHelper", StudentDAOHelper.class);
		studentDAOHelper.setUpStudentTable();

		// GET ALL STUDENTS
		StudentDAOImpl studentDAOImpl = context.getBean("studentdaoimpl", StudentDAOImpl.class);
		List<Student> studentsList = studentDAOImpl.findAllStudents();
		studentDAOHelper.printAllStudents(studentsList);

		// GET BY ID
	/*	System.out.print("Get student by id: ");
		Student student = studentDAOImpl.findStudentById(2);
		System.out.println(student);
   */
		
		// DELETE BY ID
		//boolean isDeleted = studentDAOImpl.deleteById(2);
		/*if (isDeleted) {
			System.out.println("Student record deleted successfully");
		}*/
		
		// DELETE BY NAME AND ADDRESS
		//int deleteRowCount = studentDAOImpl.deleteRecordByStudentNameOrStudentAddress("Ujjwal", 30);
		//System.out.println("Number of records deleted : " + deleteRowCount);
		
		// GROUP BY ADDRESS
//		Map<String, List<String>> groupStudentsByAddress = studentDAOImpl.groupStudentsByAddress();
//		System.out.println("*************************************************************************************");
//		System.out.println(groupStudentsByAddress);
//		System.out.println("**************************************************************************************");

		// UPDATE
//		Student diana = new Student();
//		diana.setId(3);
//		diana.setAddress("NewYork");
//		
//		Student sameer = new Student();
//		sameer.setId(6);
//		sameer.setAddress("Hyderabad");
//		
//		Student ajay = new Student();
//		ajay.setId(7);
//		ajay.setAddress("Malaysia");
////		ajay.setAddress("Malaysiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		
//		List<Student> updateList = new ArrayList<>();
//		updateList.add(diana);
//		updateList.add(sameer);
//		updateList.add(ajay);
		
		// UPDATE SINGLE
//		studentDAOImpl.update(diana);
		
		// UPDATE MULTIPLE
//		int batchUpdateRowCount = studentDAOImpl.updateMultiple(updateList);
//		System.out.println(batchUpdateRowCount + " records updated successfully");
		
		// TRUNCATE TABLE
//		studentDAOImpl.truncateTable();

		// DESTROYING APPLICATION CONTEXT
		((ClassPathXmlApplicationContext) context).close();
	}
}
