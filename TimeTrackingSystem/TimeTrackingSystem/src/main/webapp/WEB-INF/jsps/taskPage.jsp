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
<h2 align="center">Task Details</h2>
<form action="savedTask"  method="post">
<table>
<tr><td>ProjectId:</td><td><input type="text" name="projectId" required></td></tr>
<tr><td>TaskTitle:</td><td><input type="text" name="taskTitle" required></td></tr>
<tr><td>ProjectDescription:</td><td><input type="text" name="projectDespn" required></td></tr>
<tr><td>TaskDescription:</td><td><input type="text" name="taskDspn" required></td></tr>
<tr><td>TaskStartDate:</td><td><input type="date" name="taskStartDate" required></td></tr>
<tr><td>TaskEndDate:</td><td><input type="date" name="taskEndDate" required></td></tr>
<tr><td>EmployeeId:</td><td><input type="text" name="empId" required></td></tr>

<tr><td align="center" colspan="2"> <input type="submit" value="save"/></td></tr>
</table>
</form>
<a href="displayTask">View Task</a>


</body>
</html>