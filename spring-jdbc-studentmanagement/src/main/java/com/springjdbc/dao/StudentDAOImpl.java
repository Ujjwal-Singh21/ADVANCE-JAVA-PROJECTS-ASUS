package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springjdbc.api.Student;
import com.springjdbc.api.StudentDTO;
import com.springjdbc.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	// GET-ALL
	// --------
	@Override
	public List<Student> loadStudents() {
		String selectQuery = "SELECT * FROM STUDENTS";
		List<Student> studentsList = jdbctemplate.query(selectQuery, new StudentRowMapper());
		return studentsList;
	}

	// ADD
	// ----
	@Override
	public void addStudent(StudentDTO studentDTO) {
		Object[] sqlArgs = { studentDTO.getName(), studentDTO.getMobile(), studentDTO.getCountry() };
		String insertQuery = "INSERT INTO STUDENTS (name, mobile, country) VALUES (?, ?, ?)";
		int addCount = jdbctemplate.update(insertQuery, sqlArgs);
		System.out.println(addCount + " record inserted successfully");
	}

	// GET BY ID
	// -----------
	@Override
	public Student getById(int id) {
		String selectByIdQyery = "SELECT * FROM STUDENTS WHERE ID = ?";
		return jdbctemplate.queryForObject(selectByIdQyery, new StudentRowMapper(), id);
	}

	// UPDATE
	// -------
	@Override
	public void updateStudent(StudentDTO studentDTO) {
		String updateQuery = "UPDATE STUDENTS SET NAME = ?, MOBILE = ?, COUNTRY = ? WHERE ID = ?";
		Object[] updateArgs = { studentDTO.getName(), studentDTO.getMobile(), studentDTO.getCountry(), studentDTO.getId() };
		int updateCount = jdbctemplate.update(updateQuery, updateArgs);
		System.out.println(updateCount + " record of " + studentDTO.getName() + " updated sucessfully");
	}

	// DELETE
	//--------
	@Override
	public void deleteById(int userId) {
		String deleteQuery = "DELETE FROM STUDENTS WHERE ID = ?";
		jdbctemplate.update(deleteQuery, userId);
	}

}
