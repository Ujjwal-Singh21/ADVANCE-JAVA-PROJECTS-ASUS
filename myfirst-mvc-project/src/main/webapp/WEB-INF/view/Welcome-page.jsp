<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h2 align="center"> MOM'S CAFE </h2>
		<hr />
		<br>
		
		<div align="center">
		    <form action="processOrder">
			<label for="food-type"> Food Type: </label>
			<input type="text" id="food-type" name="foodType" placeholder="food type??">
			<input type="submit" value="Place Your Order">
		</form>
		</div>
	</body>
</html>