<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>${msg}</h2>
<body>
<form action="saveLogin" method="post">
<pre>
<input type="text" name="username" placeholder="UserName" required>
<input type="text" name="password" placeholder="Password" required>
<input type="submit" value="Login"/>
</pre>
</form>
</body>
</html>