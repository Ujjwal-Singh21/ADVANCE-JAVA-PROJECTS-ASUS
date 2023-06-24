package com.springjdbc.service;

import java.util.List;

import com.springjdbc.api.Student;
import com.springjdbc.api.StudentDTO;

public interface IStudentService {

	public abstract List<Student> loadStudents();

	public abstract void addStudent(StudentDTO studentDTO);
	
	public abstract Student getById(int id);
	
	public abstract void updateStudent(StudentDTO studentDTO);

	public abstract void deleteById(int userId);
}
