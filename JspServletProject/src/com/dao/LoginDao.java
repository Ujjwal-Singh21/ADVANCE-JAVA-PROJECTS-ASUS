package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public boolean checkDetails(String uname, String pass) throws ClassNotFoundException, SQLException {

		String url = "jdbc:postgresql://localhost:5432/hibernatedb";
		String username = "postgres";
		String password = "ujjwal";
		String query = "select * from login where username=? and password=?";

		Class.forName("org.postgresql.Driver"); // ClassNotFoundException
		Connection conn = DriverManager.getConnection(url, username, password); // SQLException

		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, uname);
		pstmt.setString(2, pass);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			return true;
		}
			
		return false;
	}

}
