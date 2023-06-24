<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sign-up page</title>
	</head>
	<body>
		<h3> Sign up page </h3>
		<form:form action="process-signup" method="POST" modelAttribute="signupDTO">
		    <label> USERNAME : </label>
			<form:input path="username"/>
			<br />
			<label> PASSWORD : </label>
			<form:password path="password"/>
			<br/>
			<input type="submit" value="SIGNUP" />
		</form:form>
	</body>
</html>