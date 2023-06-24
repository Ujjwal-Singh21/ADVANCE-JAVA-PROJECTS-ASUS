<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Name: <h2>${formData.name}</h2> <br>
	UserName: <h2>${formData.username}</h2> <br>
	Password: <h2>${formData.password}</h2> <br>
	Country: <h2>${formData.country}</h2> <br>
	
	Hobbies:
	<c:forEach var="hobby" items="${formData.hobbyArr}">
		${hobby} <br>
	</c:forEach> <br>
	
	Gender: <h2>${formData.gender}</h2>
	
</body>
</html>