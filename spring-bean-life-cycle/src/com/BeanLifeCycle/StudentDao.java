package com.BeanLifeCycle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDao {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	// connection object
	private Connection conn; 

	// setters
	//--------
	public void setDriver(String driver) {
		System.out.println("Driver setter method");
		this.driver = driver;
	}

	public void setUrl(String url) {
		System.out.println("URL setter method");
		this.url = url;
	}

	public void setUsername(String username) {
		System.out.println("Username setter method");
		this.username = username;
	}

	public void setPassword(String password) {
		System.out.println("Password setter method");
		this.password = password;
	}
	
	// init() -> bean lifecycle method
	//--------------------------------
//	@PostConstruct
	public void init() throws Exception {
		System.out.println("init method executed");
		getStudentDBConnection();
	}
	
	// get connection method
	public void getStudentDBConnection() throws Exception {
		 Class.forName(driver);
		 conn = DriverManager.getConnection(url, username, password);
		 System.out.println("DB connection is estlablished");
	}

	// getAllRecords
	public void selectAllStudentRecords() throws Exception {

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Student");

		while (rs.next()) {
			int studentId = rs.getInt(1);
			String studentName = rs.getString(2);
			int studentFees = rs.getInt(3);
			String studentFoodType = rs.getString(4);

			System.out.println(studentId + " " + studentName + " " + studentFees + " " + studentFoodType);
		}
	}
	
	// delete a Student Record
	public void deleteStudentRecord(int studentId) throws Exception  {
		PreparedStatement pstmt = conn.prepareStatement("Delete from Student where student_id = " + studentId);
		int count = pstmt.executeUpdate();
		System.out.println(count + " record deleted successfully");
	}
	
	// destroy - bean life cycle method executed just before container is detroyed
	//-----------------------------------------------------------------------------
//	@PreDestroy
	public void destroy() throws Exception {
		closeStudentDBConnection();
		System.out.println("detsroy method executed");
	}
	
	// method used to close db connectioon
	public void closeStudentDBConnection() throws Exception {
		System.out.println("DB Connection is closed and cleared");
		conn.close();
	}

}
