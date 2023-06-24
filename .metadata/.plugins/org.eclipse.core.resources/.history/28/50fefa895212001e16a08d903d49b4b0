package com.mavenproject.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mavenproject.model.Alien;

public class AlienDao {
	
	String url = "jdbc:mysql://localhost:3306/servletdemo";
	String username = "root";
	String password = "root";
	String query = "select * from alien where aid=";
	
	public Alien getAlien(int aid) throws ClassNotFoundException, SQLException {
		
		Alien alien  = new Alien();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query + aid);
		
		while(rs.next()) {
			alien.setAid(rs.getInt("aid"));
			alien.setAname(rs.getString("aname"));
			alien.setTech(rs.getString("tech"));
		}
		return alien;	
	}
	
}
