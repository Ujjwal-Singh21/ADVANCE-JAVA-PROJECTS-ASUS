<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Change Password Page</title>
		<style type="text/css">
			i {
				font-family: cursive;
			}
		</style>
	</head>
	<body>
		<div align="center">
			
			<h3> Change password Page </h3>
			<br>
			
			<c:if test="${param.newAndConfirmPasswordsDoesNotMatch != null}">
				<i style="color: red;"> ERROR: Sorry.. NewPassword and ConfirmPassword does not matches.. </i>
			</c:if>
			<br />
			
			<c:if test="${param.InvalidPassword != null}">
				<i style="color: red;"> Error: Invalid Password </i>
			</c:if>
			<br /> <br />
			
			<form:form action="process-password-change" method="POST" modelAttribute="change-password-dto">
				<label> Old Password: </label>
				<form:input path="oldPassword"/>
				<br /> <br /> 
				
				<label> New Password: </label>
				<form:input path="newPassword"/>
				<br /> <br /> 
				
				<label> Confirm New Password: </label>
				<form:input path="confirmNewPassword"/>
				<br /> <br /> <br />
				
				<input type="submit" value="CHANGE PASSWORD" />
				<br />
			</form:form>
		</div>
	</body>
</html>