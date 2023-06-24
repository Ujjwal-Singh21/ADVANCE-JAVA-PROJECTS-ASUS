<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
	  <%
	    /*  To get rid of back button after Logout  */
	    
	   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
       response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
       response.setHeader("Expires", "0"); // Proxies.
	    
	     if(session.getAttribute("username") == null) {
	    	 response.sendRedirect("Login.jsp");
	     }
	  %>
	  
	  Welcome ${username} <br>
	  <a href="Videos.jsp"> Go to Videos Page </a>       <br> <br> <br>
	  
	  <form action="Login.jsp">
	      <input type="submit" value="Logout">
	  </form>
	</body>
</html>