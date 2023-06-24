package com.springjdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springjdbc.api.Student;
import com.springjdbc.resultsetextractor.StudentAddressResultSetExtractor;
import com.springjdbc.resultsetextractor.StudentResultSetExtractor;
import com.springjdbc.rowmapper.StudentRowMapper;

@Repository("studentdaoimpl")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// setter
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// INSERT
	//-------
	@Override
	public void insert(Student student) {

		String insertQuery = "INSERT INTO STUDENT_TABLE values (?, ?, ?)";

		Object[] args = { student.getId(), student.getName(), student.getAge() };

		int insertedRowCount = jdbcTemplate.update(insertQuery, args);

		System.out.println("Number of records inserted " + insertedRowCount);
	}

	// INSERT MULTIPLE
	//----------------
	@Override
	public void insertMultiple(List<Student> studentsList) {

		List<Object[]> args = new ArrayList<>();

		for (Student s : studentsList) {
			Object[] studentData = { s.getId(), s.getName(), s.getAge(), s.getAddress() };
			args.add(studentData);
		}

		String multipleInsertQuery = "INSERT INTO STUDENT_TABLE (id, name, age, address) values (?, ?, ?, ?)";

		jdbcTemplate.batchUpdate(multipleInsertQuery, args);

		System.out.println(">>>>>> Batch Insert Completed <<<<<<<");
	}

	// FIND ALL STUDENTS
	//------------------
	@Override
	public List<Student> findAllStudents() {
		String selectAllQuery = "SELECT * FROM STUDENT_TABLE";
//       List<Student> studentsList = jdbcTemplate.query(selectAllQuery, new StudentRowMapper());
       List<Student> studentsList = jdbcTemplate.query(selectAllQuery, new StudentResultSetExtractor());
//		List<Student> studentsList = jdbcTemplate.query(selectAllQuery, new BeanPropertyRowMapper<Student>(Student.class));
		return studentsList;
	}

	// FIND BY ID
	//-----------
	@Override
	public Student findStudentById(int id) {
		String findByIdQuery = "SELECT * FROM STUDENT_TABLE WHERE ID = ?";
		// String findByIdQuery = "SELECT STUDENT_ID as id, STUDENT_NAME as name, STUDENT_AGE as age FROM STUDENT WHERE ID = ?";
		Student student = jdbcTemplate.queryForObject(findByIdQuery, new BeanPropertyRowMapper<Student>(Student.class), id);
		return student;
	}
	
	// DELETE BY ID
	//-------------
	@Override
	public boolean deleteById(int id) {
		String deleteQuery = "DELETE FROM STUDENT_TABLE WHERE ID = ?";
		int deleteRowCount = jdbcTemplate.update(deleteQuery, id);
		return deleteRowCount == 1;
	}
	
	// DELETE WITH DIFFERENT CRITERIAS
	//--------------------------------
	@Override
	public int deleteRecordByStudentNameOrStudentAddress(String name, int age) {
		String deleteQuery = "DELETE FROM STUDENT_TABLE WHERE NAME = ? OR AGE = ?";
		Object[] args = {name, age};
		// int deleteRowCount = jdbcTemplate.update(deleteQuery, name, age);
		int deleteRowCount = jdbcTemplate.update(deleteQuery, args);
		return deleteRowCount;
	}
	
	// GROUP STUDENTS BY ADDRESS
	//--------------------------
	@Override
	public Map<String, List<String>> groupStudentsByAddress() {
		String groupQuery = "SELECT * FROM STUDENT_TABLE";
		Map<String, List<String>> studentsMapList = jdbcTemplate.query(groupQuery, new StudentAddressResultSetExtractor());
		return studentsMapList;
	}
	
	// SINGLE UPDATE
	//--------------
	@Override
	public int update(Student student) {
		String updateQuery = "UPDATE STUDENT_TABLE SET ADDRESS = ? WHERE ID = ?";
		Object[] args = { student.getAddress(), student.getId() };
		System.out.println(student.getId() + " id record updated successfully");
		return jdbcTemplate.update(updateQuery, args);
	}
	
	// BATCH UPDATE
	//-------------
	@Override
	@Transactional
	public int updateMultiple(List<Student> studentsList) {
		String updateQuery = "UPDATE STUDENT_TABLE SET ADDRESS = ? WHERE ID = ?";
		int updateRowCount = 0;
		
		int[] batchUpdateCount = jdbcTemplate.batchUpdate(updateQuery, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt, int index) throws SQLException {
				// INSIDE THIS METHOD WE SET VALUES TO OUR QUERY OR SET ARGS FOR PREPATED_STATEMENT
				// INSIDE THIS METHOD, PREPARED_STATEMENT FIRST GIVES ABOVE QUERY TO DATABASE AND ASK TO COMPILE IT AND TAKES IT BACK
				// THEN IT EXECUTES THAT COMPILED QUERY AS MANY TIMES AS REQUIRED BY SIMPLY CHANGING ARGUMNETS IN THE QUERY FOR DIFFERENRT RECORDS
				pstmt.setString(1, studentsList.get(index).getAddress());
				pstmt.setInt(2, studentsList.get(index).getId());
				System.out.println("Inside set values method");
			}
			
			@Override
			public int getBatchSize() {
				// INSIDE THIS METHOD WE SPECIFY HOW MANY TIMES OUR UPDATE QUERY WILL GET EXECUTED
				// MEANS HOW MANY TIMES ABOVE METHOD SETVALUES GETS EXECUTED
				System.out.println("Inside getBatchSize method which is executed " + studentsList.size() + " times");
				return studentsList.size();
			}
		});
		
		for(int i = 0;  i < batchUpdateCount.length; i++) {
			if(batchUpdateCount[i] == 1) {
				updateRowCount++;
			}
		}
		return updateRowCount;
	}


	// TRUNCATE
	//---------
	@Override
	public void truncateTable() {
		String truncateQuery = "TRUNCATE TABLE STUDENT_TABLE";
		jdbcTemplate.execute(truncateQuery);
		System.out.println("<<<<<<<< Table cleaned Up >>>>>>>>");
	}

}
