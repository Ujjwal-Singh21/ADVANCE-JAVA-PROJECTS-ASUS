<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home page</title>
	</head>
	
	<script type="text/javascript">
		function validateUsername() {
			var username = document.getElementById("un").value;
			
			if(username < 1) {
				alert("username should be more than 1 character");
				return true;
			} else {
				return false;
			}
		}
	</script>
	
	<style>
		.error {
			text-align: center;
			color: red;
			margin-left: 10px;
			position: fixed;
			font-family: cursive;
		}
	</style>
	
	<body>
	
		<h1 align="center">Calculator</h1>
		<hr />
		<form:form action="process-homepage" method="get" modelAttribute="userDTO">
			<div align="center">
				<p> 
					<label for="un"> Your Name  : </label>
					<!-- <input type="text" id="un" name="username"/> -->
					<form:input id="un" path="username"/>
					<form:errors path="username" cssClass="error"/>
				</p> <br>
				
				<p> 
					<label for="cn"> Crush Name : </label>
					<!-- <input type="text" id="cn" name="crushname"/> -->
					<form:input id="cn" path="crushname"/>
					<form:errors path="crushname" cssClass="error"/>
				</p> <br>
				
				<p> 
				   <form:checkbox path="termsAndCondition"/>
				   <label> You are agreeing that this is for fun </label>
				   <form:errors path="termsAndCondition" cssClass="error"/>
				</p> <br>
				
				<input type="submit" value="calculate">
			</div>
		</form:form>
		
	</body>
</html>