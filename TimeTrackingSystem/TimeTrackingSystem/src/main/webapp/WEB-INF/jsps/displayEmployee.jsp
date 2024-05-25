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
<th>EmployeeId</th>
<th>EmployeeName</th>
<th>EmployeeAddress</th>
<th>EmployeePhoneNo</th>
<th>EmployeeDob</th>
<th>EmployeeDoj</th>
<th>EmployeeDepartment</th>
<th>EmployeeDesignation</th>
</tr>
<c:forEach items="${employee}" var="employee">
<tr>
<td>${employee.empId}</td>
<td>${employee.empName}</td>
<td>${employee.empAddress}</td>
<td>${employee.empPhoneNo}</td>
<td>${employee.empDob}</td>
<td>${employee.empDateOfJoin}</td>
<td>${employee.empDepartment}</td>
<td>${employee.empDesignation}</td>
<td><a href="employee-delete?id=${employee.empId}">delete</a> 
<a href="edit-employee?id=${employee.empId}">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>