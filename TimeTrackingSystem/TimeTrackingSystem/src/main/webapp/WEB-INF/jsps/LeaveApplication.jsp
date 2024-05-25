<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Leave Application</h2>
<form action="saveAppln" method="post">
<table align="center">
<tr><td>EmployeeId:</td><td><input type="text"  name="empId" required/></td></tr>
<tr><td>From:</td><td><input type="text"  name="from" required/></td></tr>
<tr><td>To:</td><td><input type="text"  name="to" required/></td></tr>
<tr><td>Subject:</td><td><input type="text"  name="subject" required/></td></tr>
<tr><td>Content:</td><td><textarea name="content" required></textarea></td></tr>
<tr><td>Date:</td><td><input type="date"  name="date" required/></td></tr>
<tr><td align="center" colspan="2"><input type="submit" value="Submit"/></td></tr>
</table>
</form>
</body>
</html>