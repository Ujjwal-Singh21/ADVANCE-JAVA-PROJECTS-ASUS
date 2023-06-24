<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
  <h1 align="center"> Calculator </h1>
  <hr />
  
 <%--  Username: ${username}
  Crushname: ${crushname} --%>
  
  <h2> The calculator predicts: </h2>
  <br>
  ${userDTO.username} and ${userDTO.crushname} are
  <br>
  FRIEND
  <br>
  
  <a href="sendEmail"> Send result to your Email </a>
  
</body>
</html>