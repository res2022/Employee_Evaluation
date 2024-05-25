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
<th>ProjectId</th>
<th>ClientId</th>
<th>ProjectTitle</th>
<th>ProjectDescription</th>
<th>ProjectDeliveryDate</th>
</tr>
<c:forEach items="${project}" var="project">
<tr>
<td>${project.projectId}</td>
<td>${project.clientId}</td>
<td>${project.projectTitle}</td>
<td>${project.projectDes}</td>
<td>${project.projectDeliveryDate}</td>
<td><a href="project-delete?id=${project.projectId}">delete</a> 
<a href="edit-project?id=${project.projectId}">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>