<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">Employee Registration</h2>
<form action="savedEmployee" method="post" >
<table><tr><td>EmployeeName:</td><td><input type="text" name="empName" pattern="[a-z A-Z]+"  required /></td></tr>
<tr><td>EmployeeAddress:</td><td><textarea name="empAddress" required></textarea></td></tr>
<tr><td>EmployeePhoneNo:</td><td><input type="text" name="empPhoneNo" pattern="[0-9]{10}" required /></td></tr>
<tr><td>EmployeeDob:</td><td><input type="date" name="empDob" required/></td></tr>
<tr><td>EmployeeDoj:</td><td><input type="date" name="empDateOfJoin" required /></td></tr>
<tr><td>EmployeeDepartment:</td><td><input type="text" name="empDepartment" required /></td></tr>
<tr><td>EmployeeDesignation:</td><td> <select name="empDesignation" required>
<option>Admin</option>
<option>ProjectManager</option>
<option>Developer</option>
<option>Designer</option>
<option>Accountant</option>

</select></td></tr>
<tr><td align="center" colspan="2"><input type="submit" value="SAVE"/></td></tr>
</table>

</form>
<a href="displayEmployee" style="color:red;">View Employee</a>
<a href="leaveAppln" style="color:red;">Leave Application</a>

</body>


</html>