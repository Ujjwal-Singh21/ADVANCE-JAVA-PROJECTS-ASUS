<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" 
		      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="/spring-jdbc-studentmanagement/UrltoReachResourcesFolder/css/style-sheet.css">
	</head>
	
	<body class="myFonts">
		
		<div class="container">
		
			<h1> STUDENT-MANAGEMENT-APPLICATION </h1>
		    <h2> Students List </h2>
		    <hr>
		    
		    <form action="add-Student">
				<input type="submit" value="+ ADD NEW STUDENT" class="btn btn-warning"/>
			</form>
			<br>
			
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th> ID </th>
						<th> NAME </th>
						<th> MOBILE </th>
						<th> COUNTRY </th>
						<th colspan="2"> ACTIONS </th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="student" items="${students}">
						<tr> 
							<td> ${student.id} </td>
							<td> ${student.name} </td>
							<td> ${student.mobile} </td>
							<td> ${student.country} </td>
							<td> <a href="/spring-jdbc-studentmanagement/update-Student?userId=${student.id}"
							        class="btn btn-success"> 
							        UPDATE 
							      </a>
							</td>
							<td> <a href="/spring-jdbc-studentmanagement/delete-Student?userId=${student.id}"
							        onclick="if(!(confirm('Are you sure u want to delete..?'))) return false" 
							        class="btn btn-danger">
							        DELETE 
							     </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<!-- <img alt="students fake img" src="/spring-jdbc-studentmanagement/UrltoReachImagesFolder/student.png"> -->
		</div>
	</body>
</html>