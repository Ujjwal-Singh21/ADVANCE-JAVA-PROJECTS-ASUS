package com.springjdbc.dao;

import java.util.List;
import java.util.Map;

import com.springjdbc.api.Student;

public interface StudentDAO {

	public abstract void insert(Student student);

	public abstract void insertMultiple(List<Student> studentsList);
	
	public abstract List<Student> findAllStudents();
	
	public abstract Student findStudentById(int id);
	
	public abstract boolean deleteById(int id);
	
	public abstract int deleteRecordByStudentNameOrStudentAddress(String name, int age);
	
	public abstract Map<String, List<String>> groupStudentsByAddress();
	
	public abstract int update(Student student);
	
	public abstract int updateMultiple(List<Student> studentsList);
	
	void truncateTable();

}
