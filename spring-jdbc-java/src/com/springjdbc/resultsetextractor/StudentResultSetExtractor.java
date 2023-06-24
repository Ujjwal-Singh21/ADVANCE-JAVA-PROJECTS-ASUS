package com.springjdbc.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springjdbc.api.Student;

// ResultSetExtractor gets all records inside resultset at a time, process it, and returns List of students
// RowMapper gets records one by one row at a time, process it, and returns one-one object at a time.
public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
	
		List<Student> studentsList = new ArrayList<>();
		
		while(rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAge(rs.getInt("age"));
			student.setAddress(rs.getString("address"));
			studentsList.add(student);
		}
		
		System.out.println("ResultSetExtractor executed...!!!");
		return studentsList;
	}

}
