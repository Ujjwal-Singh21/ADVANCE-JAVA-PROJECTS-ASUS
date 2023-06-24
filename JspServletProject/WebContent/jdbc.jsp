
<!-- Directive -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Imported java.sql package for sql related exceptions -->
<%@ page import="java.sql.*" %> 
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> JDBC TITLE PAGE </title>
	</head>

	<body bgcolor="pink">
	
			<!-- Declaration -->
	        <%! 
	        	int empId;
	        	String empName;
	        	int empSalary;
	        %>
	        
	        <!-- Scriptlet -->
			<%
				String url = "jdbc:postgresql://localhost:5432/hibernatedb";
				String username = "postgres";
				String password = "ujjwal";
				String query = "select * from employee where empid=103";
				
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, username, password);
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					empId = rs.getInt(1);
					empName = rs.getString(2);
					empSalary = rs.getInt(3);
				}
			%>
			
			<!-- Expression -->
			EMPLOYEE ID: <%= empId  %> <br>
			EMPLOYEE NAME: <%= empName %> <br>
			EMPLOYEE SALARY: <%= empSalary %> <br>
	</body>
</html>