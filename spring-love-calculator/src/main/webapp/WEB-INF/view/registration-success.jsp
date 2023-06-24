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
	Name: <h2>${userReg.name}</h2> <br>
	UserName: <h2>${userReg.username}</h2> <br>
	Password: <h2>${userReg.password}</h2> <br>
	Country: <h2>${userReg.country}</h2> <br>
	
	Hobbies:
	<c:forEach var="hobby" items="${userReg.hobbyArr}">
		${hobby} <br>
	</c:forEach> <br>
	
	Gender: <h2>${userReg.gender}</h2> <br>
	
	Age: <h2>${userReg.age}</h2> <br>
	
	PhoneNumber: <h2>${userReg.communicationDTO.phone}</h2>
	Email: <h2>${userReg.communicationDTO.email}</h2> <br>
	
</body>
</html>