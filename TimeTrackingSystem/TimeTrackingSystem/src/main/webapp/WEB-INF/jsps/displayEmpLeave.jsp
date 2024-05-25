<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">

<tr>
<th>EmployeeId</th>
<th>From</th>
<th>To</th>
<th>Subject</th>
<th>Content</th>
<th>date</th>
<c:forEach items="${leaveAppln}" var="leaveAppln">
<tr>
<td>${leaveAppln.empId}</td>
<td>${leaveAppln.from}</td>
<td>${leaveAppln.to}</td>
<td>${leaveAppln.subject}</td>
<td>${leaveAppln.content}</td>
<td>${leaveAppln.date}</td>

<td><a href="leaveAppln-Approve?id=${leaveAppln.empId}">Approve</a> 
<td><a href="leaveAppln-Reject?id=${leaveAppln.empId}">Reject</a> 

</c:forEach>
</table>
</body>
</html>