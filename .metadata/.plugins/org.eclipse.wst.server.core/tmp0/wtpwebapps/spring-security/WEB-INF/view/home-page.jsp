<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home page</title>
		<style>
			a {
				background-color: green;
				color: white;
				font-family: cursive;
			}
		</style>
	</head>
	<body>
		<h2>Welcome to Home page</h2>
		<strong> Hi ${username}, </strong>
		<strong> Your roles are: ${roles}</strong>
		<br>
		<br>
	
		<sec:authorize access='hasAuthority("Trainer")'>
			<a href="/spring-security/trainer"> Go to Trainer's Dashboard </a>
		</sec:authorize>
		<br />
		<br />
	
		<sec:authorize access='hasAuthority("Coder")'>
			<a href="/spring-security/coder"> Go to Coder's Dashboard </a>
		</sec:authorize>
		<br />
		<br />
		
		<!-- Delete user -->
		<a href="/spring-security/delete-user?username=${username}"> Delete User </a>
		<br> <br>
		
		<!-- Change password -->
		<a href="/spring-security/change-password"> Change Password </a>
		<br> <br>
	
		<form:form action="logout" method="POST">
			<input type="submit" value="LOGOUT" />
		</form:form>
	</body>
</html>