<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <!-- Here we will declare a string using core tag, and try to apply diff functions from function library in JSTL -->
  <c:set var="str" value="My name is Ujjwal Singh"/>
  
  Length: ${fn:length(str)}      <br>
  
  Split:  <c:forEach items="${fn:split(str, ' ')}" var="s">
               <c:out value="${s}" /> <br>
          </c:forEach>
          
  Contains: ${fn:contains(str, "Ujjwal")}  <br>
  
  Ends with: ${fn:endsWith(str, "Singh")}  <br>
  
  <c:if test="${fn:endsWith(str, 'Singh')}">
  		Yes It ends with Singh
  </c:if>
 

</body>
</html>