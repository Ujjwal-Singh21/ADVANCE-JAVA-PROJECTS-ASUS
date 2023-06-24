<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home page</title>
	</head>
	
	<body>
	
		<h1 align="center">Love Calculator</h1>
		<hr />
		<form:form action="process-homepage" method="get" modelAttribute="initialUserDTO">
			<div align="center">
				<p> 
					<label for="un"> Your Name: </label>
					<!-- <input type="text" id="un" name="username"/> -->
					<form:input id="un" path="username"/>
					<form:errors path="username"/>
				</p>
				
				<p> 
					<label for="cn"> Crush Name: </label>
					<!-- <input type="text" id="cn" name="crushname"/> -->
					<form:input id="cn" path="crushname"/>
				</p>
				
				<input type="submit" value="calculate">
			</div>
		</form:form>
		
	</body>
</html>