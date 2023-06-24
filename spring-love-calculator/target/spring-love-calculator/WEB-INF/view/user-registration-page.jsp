<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Form</title>
	</head>
	<body>
		<h1 align="center"> User Registration Page </h1>
		<hr />
		
		<form:form action="registration-success" method="get" modelAttribute="intialformData">
			<div align="center">
				<p> 
					<label for="name"> Name : </label>
					<form:input id="name" path="name"/>
				</p>
				
				<p> 
					<label for="un"> User Name : </label>
					<form:input id="un" path="username"/>
				</p>
				
				<p> 
					<label for="pass"> Password : </label>
					<form:password id="pass" path="password"/>
				</p>
				
				<p> 
					<label for="country"> Country : </label>
					<form:select id="country" path="country">
						<form:option value="">--Select--</form:option>
						<form:option value="india">India</form:option>
						<form:option value="usa">USA</form:option>
						<form:option value="australia" label="Australia"></form:option>
						<form:option value="london" label="London"></form:option>
					</form:select>
				</p>
				
				<p> 
					 <label for="hobby"> Hobby : </label>
			         <form:checkbox value='Cricket' path="hobbyArr" /> Cricket 
			         <form:checkbox value='Reading' path="hobbyArr" /> Reading
			         <form:checkbox value='Travel' path="hobbyArr"/> Travel
			         <form:checkbox value='Programming' path="hobbyArr"/> Programming
				</p>
				
				<p> 
					<label> Gender : </label>
			        <form:radiobutton value='Male' path="gender" /> Male
			        <form:radiobutton value='Female' path="gender"/> Female
				</p>
				
				<input type="submit" value="calculate">
			</div>
		</form:form>
	</body>
</html>