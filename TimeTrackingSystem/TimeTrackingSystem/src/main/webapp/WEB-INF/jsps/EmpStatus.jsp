<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2 align="center">Employee Status</h2>
<form action="savedEmpStatus" method="post" >
<table><tr><td>TaskId:</td><td><input type="text" name="taskId"  required /></td></tr>
<tr><td>TaskTitle:</td><td><textarea name="taskTitle" required></textarea></td></tr>
<tr><td>EmployeeId:</td><td><input type="date" name="empId" required/></td></tr>
<tr><td>Date:</td><td><input type="date" name="date" required /></td></tr>
<tr><td>TaskStatus:</td><td> <select name="Status" required>
<option>Pending Tasks</option>
<option>On-Progress Tasks</option>
<option>Closed Task</option>
</select></td></tr>
<tr><td align="center" colspan="2"><input type="submit" value="SAVE"/></td></tr>
</table>

</form>
</body>
</html>