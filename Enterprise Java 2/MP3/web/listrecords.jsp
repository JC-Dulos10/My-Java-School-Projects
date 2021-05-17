<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<jsp:useBean id="records" type="java.sql.ResultSet" scope="request" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Machine Problem 3</title>
<style type="text/css">
	body {
		background-color:#FFEBCD;
	}
</style>
</head>
<body>
	<img src='image/cover.jpg' width="100%" height="100%"> 
	<h2>Display All Records</h2>
		<% while (records.next()) {%>
		<table border="1" cellpadding="2px" cellspacing="2px" align="center">
				<tr>
					<th>ID: </th>
					<td align="center"><%=records.getInt("id") %></td>
				</tr>
				<tr>
					<th>Bus Name: </th>
					<td align="center"><%=records.getString("busName") %></td>
				</tr>
				<tr>
					<th>Plate Number: </th>
					<td align="center"><%=records.getString("plateNumber")%></td>
				</tr>
				<tr>
					<th>Driver: </th>
					<td align="center"><%=records.getString("driver")%></td>
				</tr>
				<tr>
					<th>Coding Day Assigned: </th>
					<td align="center"><%=records.getString("codingDayAssigned")%></td>
				</tr>
			</table>
			<br>
		<% } %>
	
	<hr/>
	<form action='index.html'>
		<input type="submit" value='<< GO BACK >>'>
	</form>
</body>
</html>