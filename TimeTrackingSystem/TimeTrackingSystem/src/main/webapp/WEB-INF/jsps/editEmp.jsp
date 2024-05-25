<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Edit</h2>
<form action="updateEmployee" method="post">
<pre>
EmployeeId:<input type="text" name="empId" value="${employee.empId}" /><br/>
EmployeeName:<input type="text" name="empName" value="${employee.empName}" /><br/>
EmployeeAddress:<input type="text"  name="empAddress"  value="${employee.empAddress}" /><br/>
EmployeePhoneNo:<input type="text" name="empPhoneNo"  value="${employee.empPhoneNo}" /><br/>
EmployeeDob:<input type="date"  name="empDob"  value="${employee.empDob}" /><br/>
EmployeeDoj:<input type="date"  name="empDateOfJoin"   value="${employee.empDateOfJoin}" /><br/>
EmployeeDepartment:<input type="text"  name="empDepartment"   value="${employee.empDepartment}" /><br/>
EmployeeDesignation: <select name="empDesignation">
<option ${employee.empDesignation=='Admin'?'selected':''}>Admin</option>
<option ${employee.empDesignation=='ProjectManager'?'selected':''}>ProjectManager</option>
<option ${employee.empDesignation=='Developer'?'selected':''}>Developer</option>
<option ${employee.empDesignation=='Designer'?'selected':''}>Designer</option>
<option ${employee.empDesignation=='Accountant'?'selected':''}>Accountant</option>

</select><br/>
<input type="submit" value="save"/>
</pre>

</form>




</body>
</html>