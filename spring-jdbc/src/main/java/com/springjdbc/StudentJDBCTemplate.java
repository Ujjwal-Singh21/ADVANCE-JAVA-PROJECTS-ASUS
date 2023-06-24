package com.springjdbc;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	// its a setter function used for injecting values from beans.xml
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer age) {
		String insertQuery = "insert into Student (name, age) values (?, ?)";
		jdbcTemplateObject.update(insertQuery, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}

	@Override
	public List<Student> listStudents() {
		String selectQuery = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(selectQuery, new StudentMapper());
		return students;
	}
}
