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
<table border="2">

<tr>
<th>ClientId</th>
<th>ClientName</th>
<th>ClientOrganizationName</th>
<th>ClientAddress</th>
<th>ClientEmail</th>
<th>ClientPhoneNo</th>
<th>ClientWebsiteUrl</th>
<th>ClientWorkingDays</th>
<th>ClientHours</th>
</tr>
<c:forEach items="${client}" var="client">
<tr>
<td>${client.clientId}</td>
<td>${client.clientName}</td>
<td>${client.clientOrganizationName}</td>
<td>${client.clientAddress}</td>
<td>${client.clientEmail}</td>
<td>${client.clientPhoneNo}</td>
<td>${client.clientWebsiteUrl}</td>
<td>${client.clientWorkingDays}</td>
<td>${client.clientHours}</td>
<td><a href="client-delete?id=${client.clientId}">delete</a> 
<a href="edit-client?id=${client.clientId}">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>