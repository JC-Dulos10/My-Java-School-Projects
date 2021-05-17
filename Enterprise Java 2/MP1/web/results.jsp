<%@ page import="java.util.Date" %>
<%--useBean declaration on creating the bean instance  --%>
<jsp:useBean id="bus" class="model.BusBean"/>

<jsp:setProperty property="*" name="bus"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Machine Problem 1</title>
<style type="text/css">
	body {
		background-color:#FFEBCD;
	}
</style>
</head>
<body>
	<img src='image/cover.jpg' width="100%" height="100%"> 
	<h2>Machine Problem 1 (JSP Action Tags)</h2>
	
	<%
		bus.findDateCoding();
		if(bus.isValid() == false){
	%>
	
	<h2>Plate Number Input is wrong</h2>
	<p>The input in the Plate number is wrong...please try again
	</p>
	
	<%} else if(bus.isValid() == true){%>	
	
	<h2>Results</h2>
	<p>The <b>${bus.busName}</b> with plate number <b>${bus.plateNumber}</b> belongs to <b>${bus.dateCoding}</b> coding. 
	</br> Assigned driver is <b>${bus.driverAssigned}</b>.</p>
	
	
	<%} %>
	
	<hr/>
	
	<form action='index.jsp'>
		<input type="submit" value='GO BACK'>
	</form>
</body>
</html>