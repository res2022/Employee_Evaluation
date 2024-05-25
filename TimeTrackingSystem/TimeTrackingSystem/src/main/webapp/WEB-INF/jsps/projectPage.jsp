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
<h2 align="center">Project Details</h2>
<form action="savedProject" method="post" >
<table align="center">

<tr><td>ClientId:</td><td><input type="text" name="clientId" required></td></tr>
<tr><td>ProjectTitle:</td><td><input type="text" name="projectTitle" required></td></tr>
<tr><td>ProjectDescription:</td><td><input type="text" name="projectDes" required></td></tr>
<tr><td>ProjectDeliveryDate:</td><td><input type="date" name="projectDeliveryDate" required></td></tr>
<tr><td align="center" colspan="2"><input type="submit" value="save"/></td></tr>
</table>
</form>

<center><a href="displayProject">View Project</a></center>
</body>
</html>