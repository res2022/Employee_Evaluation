<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task</title>
</head>
<body>
<table border="2">
<tr>
<th>TaskId</th>
<th>ProjectId</th>
<th>TaskTitle</th>
<th>ProjectDescription</th>
<th>TaskDescription</th>
<th>TaskStartDate</th>
<th>TaskEndDate</th>
<th>EmployeeId</th>
</tr>
<c:forEach items="${task}" var="task">
<tr>
<td>${task.taskId}</td>
<td>${task.projectId}</td>
<td>${task.taskTitle}</td>
<td>${task.projectDespn}</td>
<td>${task.taskDspn}</td>
<td>${task.taskStartDate}</td>
<td>${task.taskEndDate}</td>
<td>${task.empId}</td>
<td><a href="task-delete?ide=${task.taskId}">delete</a> 

<a href="edit-task?id=${task.taskId}">edit</a></td>


</tr>
</c:forEach>
</table>
</body>
</html>