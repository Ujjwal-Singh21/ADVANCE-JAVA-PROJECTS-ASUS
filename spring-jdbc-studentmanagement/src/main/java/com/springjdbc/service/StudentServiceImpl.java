package com.springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjdbc.api.Student;
import com.springjdbc.api.StudentDTO;
import com.springjdbc.dao.StudentDao;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentDao dao;

	@Override
	public List<Student> loadStudents() {
		List<Student> studentsList = dao.loadStudents();
		return studentsList;
	}

	@Override
	public void addStudent(StudentDTO studentDTO) {
		dao.addStudent(studentDTO);
	}

	@Override
	public Student getById(int id) {
		return dao.getById(id);
	}

	@Override
	public void updateStudent(StudentDTO studentDTO) {
		dao.updateStudent(studentDTO);
	}

	@Override
	public void deleteById(int userId) {
		dao.deleteById(userId);
	}

}
