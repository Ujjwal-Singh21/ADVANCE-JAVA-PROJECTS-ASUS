<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" 
		      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="/spring-jdbc-studentmanagement/UrltoReachResourcesFolder/css/add-student.css">
		<link rel="stylesheet" type="text/css" href="/spring-jdbc-studentmanagement/UrltoReachResourcesFolder/css/style-sheet.css">
   </head>
	<body>
		<div class="container">
			<br> <br> 
			<h2 style="color: green"> ADD STUDENT </h2>
			<br>
		
			<form:form action="handle-AddStudent" modelAttribute="studentDTO" method="POST">
			
				<form:hidden path="id"/>
				
				<label class="form-label"> NAME : </label>
				<form:input path="name" class="form-control" />
				<br>
				
				<label class="form-label"> MOBILE : </label>
				<form:input path="mobile" class="form-control" />
				<br />
				
				<label class="form-label"> COUNTRY : </label>
				<form:input path="country" class="form-control"/>
				<br />
				
				<input type="submit" value="ADD STUDENT" class="btn btn-primary" />
		</form:form>
		</div>
	</body>
</html>