<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Client Edit</h2>
<form action="updateClient" method="post">
<pre>
ClientId:<input type="text" name="clientId" value="${client.clientId}">
ClientName:<input type="text" name="clientName"  value="${client.clientName}">
ClientOrganizationName:<input type="text" name="clientOrganizationName"  value="${client.clientOrganizationName}">
ClientAddress:<input type="text" name="clientAddress"  value="${client.clientAddress}">
ClientEmail:<input type="text" name="clientEmail"  value="${client.clientEmail}">
ClientPhoneNo:<input type="text" name="clientPhoneNo"  value="${client.clientPhoneNo}">
ClientWebsiteUrl:<input type="text" name="clientWebsiteUrl"  value="${client.clientWebsiteUrl}">
ClientWorkingDays:
 
       <input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Sunday" ${client.clientWorkingDays == 'Sunday' ? 'checked' : 'Sunday'}>
           
<input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Monday" ${client.clientWorkingDays == 'Monday' ? 'checked' : 'Monday'}>

<input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Tuesday" ${client.clientWorkingDays == 'Tuesday' ? 'checked' : 'Tuesday'}>

<input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Wednesday" ${client.clientWorkingDays == 'Wednesday' ? 'checked' : 'Wednesday'}>

<input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Thursday" ${client.clientWorkingDays == 'Thursday' ? 'checked' : 'Thursday'}>

<input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Friday" ${client.clientWorkingDays == 'Friday' ? 'checked' : 'Friday'}>

<input type="checkbox" name="clientWorkingDays" id="clientWorkingDays" value="Saturday" ${client.clientWorkingDays == 'Saturday' ? 'checked' : 'Saturday'}>



ClientHours:<input type="text" name="clientHours"  value="${client.clientHours}">


<input type="submit" value="save"/>

</pre>
</form>



</body>
</html>