<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- Expression Language -->
		 ${label} <br>
		 ${student.studentName} <br>
		 
		 <!-- Using JSTL out tag -->
		 <c:out value="${student.studentName}" /> <br>
		 
		<!--  Using JSTL forEach tag to iterate over list of students -->
		<c:forEach items="${students}" var="s">
			${s.studentId} 
			${s.studentName} <br>
		</c:forEach>
	</body>
</html>