<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2 align="center"> BILL </h2>
		<hr>
		<form:form action="process-bill" method="get" modelAttribute="billDTO">
			<div align="center">
				<p>
					<label for="cardnum"> Card Number : </label>
					<form:input id="cardnum" path="creditCard"/>
			    </p>
			    
			    <p>
					<label for="amt"> Amount : </label>
					<form:input id="amt" path="amount"/>
			    </p>
			    
			    <input type="submit" value="PAY BILL"/>
			</div>
		</form:form>
	</body>
</html>