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

<h2>Project Details</h2>
<form action="updateProject" method="post">
<pre>
ProjectId:<input type="text" name="projectId" value="${project.projectId}">
ClientId:<input type="text" name="clientId" value="${project.clientId}">
ProjectTitle:<input type="text" name="projectTitle" value="${project.projectTitle}">
ProjectDescription:<input type="text" name="projectDes" value="${project.projectDes}">
ProjectDeliveryDate:<input type="date" name="projectDeliveryDate" value="${project.projectDeliveryDate}">
<input type="submit" value="save"/>
</pre>
</form>

</body>
</html>