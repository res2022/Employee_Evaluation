<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Client Details</h2>
<form action="savedClient" method="post" >
<table>
<tr><td>ClientName:</td><td><input type="text" name="clientName" pattern="[a-z A-Z]+"  required ></td></tr>
<tr><td>ClientOrganizationName:</td><td><input type="text" name="clientOrganizationName" required></td></tr>
<tr><td>ClientAddress:</td><td><textarea  name="clientAddress" required></textarea></td></tr>
<tr><td>ClientEmail:</td><td><input type="text" name="clientEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required></td></tr>
<tr><td>ClientPhoneNo:</td><td><input type="text" name="clientPhoneNo" pattern="[0-9]{10}" required ></td></tr>
<tr><td>ClientWebsiteUrl:</td><td><input type="text" name="clientWebsiteUrl" required></td></tr>


<tr><td>ClientWorkingDays:</td><td>
			<input type="checkbox" name = "clientWorkingDays" value="Sunday" />Sunday
			<input type="checkbox" name = "clientWorkingDays" value="Monday" />Monday
			<input type="checkbox" name = "clientWorkingDays" value="Tuesday" />Tuesday
			<input type="checkbox" name = "clientWorkingDays" value="Wednesday" />Wednesday
			<input type="checkbox" name = "clientWorkingDays" value="Thursday" />Thursday
			<input type="checkbox" name = "clientWorkingDays" value="Friday" />Friday
			<input type="checkbox" name = "clientWorkingDays" value="Saturday" />Saturday
		    </td></tr>
			
<tr><td>ClientHours:</td><td><input type="text" name="clientHours" required></td></tr>


<tr><td align="center" colspan="2"><input type="submit" value="save"/></td></tr>

</table>
</form>
<a href="displayClient">View Client</a> 

</body>
</html>