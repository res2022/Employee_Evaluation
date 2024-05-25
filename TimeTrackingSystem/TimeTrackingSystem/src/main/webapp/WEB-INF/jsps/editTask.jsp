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

<h2>Task Edit</h2>
<form action="updateTask"  method="post">
<pre>
TaskId:<input type="text" name="taskId" value="${task.taskId}">
ProjectId:<input type="text" name="projectId" value="${task.projectId}">
TaskTitle:<input type="text" name="taskTitle" value="${task.taskTitle}">
ProjectDescription:<input type="text" name="projectDespn" value="${task.projectDespn}">
TaskDescription:<input type="text" name="taskDspn" value="${task.taskDspn}">
TaskStartDate:<input type="date" name="taskStartDate" value="${task.taskStartDate}">
TaskEndDate:<input type="date" name="taskEndDate" value="${task.taskEndDate}">
TaskStatus: <select name="status">
<option ${task.status=='Pending Task'?'selected':''}>Pending Task</option>
<option ${task.status=='On-Progress Task'?'selected':''}>On-Progress Task</option>
<option ${task.status=='Closed Task'?'selected':''}>Closed Task</option>


</select><br/>
EmployeeId:<input type="text" name="empId" value="${task.empId}">
 <input type="submit" value="save"/>
</pre>
</form>
<a href="displayTask">View Task</a>

</body>
</html>