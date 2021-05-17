<%@page import="com.sun.corba.se.spi.orbutil.fsm.Guard.Result"%>
<%@ page import="model.ComputeBean,java.util.Date" %>

<%!private ComputeBean result; //null;

	public void init() {
		result = new ComputeBean();
	}%>
	
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Calculator</title>
</head>
<body>
	<img src='image/head.jpg' width=100% height="150px">
	<h2 align="center">Basic Calculator</h2>
	<div class="card">
		<div class="card-body">
			<div class="container">
              <div class="row" align="center">
              	<div class="col-lg-4"> </div>
                <div class="col-lg-4" style="border-style: solid; box-shadow: 10px 10px 5px grey;" align = "center" width = 25%>
                  <br/>
                  <fieldset>
					<legend>Basic Calculator Form</legend>
					<%
						result.setValue1(Double.parseDouble(request.getParameter("value1")));
						result.setValue2(Double.parseDouble(request.getParameter("value2")));
						result.setOperator(request.getParameter("operator"));
						result.computeValue();
					%>
					
					<% if(result.getValue2() == 0){ %>
					
					<center><h3><%=result.getErrMsg() %></h3></center>
					
					<%} else { %>
					<p>The answer in the <b><%=result.getOperator() %></b> of <%=result.getValue1() %> and 
					<%=result.getValue2() %> is <b><%=result.getValue3() %></b>.
					<%} %>
				</fieldset>
				<br/>
                </div>
                <div class="col-lg-3"> </div>
              </div>
            </div>
		</div>
		<br/><br/><br/>
		<form action='index.jsp'>
			<center><button type="Submit" class="btn btn-primary">Go Back</button></center>
		</form>
		<br/><br/><br/>
		<p><i>&copy; 2020 JC Dulos</i></p>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	  integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	  crossorigin="anonymous"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	  integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	  crossorigin="anonymous"></script>
	  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	  integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	  crossorigin="anonymous"></script>
</body>
</html>