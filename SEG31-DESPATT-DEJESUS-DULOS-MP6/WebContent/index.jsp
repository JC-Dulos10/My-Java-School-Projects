<%@page import="model.phone.DisplayItem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>


<%@ page import="model.*"%>
<%@ page import="model.phone.PhoneNameRepository"%>
<%@ page import="utility.*"%>
<%@ page import="java.util.Iterator"%>

<%
	SingletonDB.checkIfPhoneTableExist();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/f7015e5bbd.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<div class="container" style="width: 120%">
	<!-- TOP  -->
	<table class="banner">
		<th><img src='images/Designs/logo.png' class = "logo" width="150" height="150"></th>
		<th></th>
		<th><span class="ShopName">Phone Pirates</span></th>
	</table>
	
	<!-- navbar  -->
	<div class="navibar">
  		<a class="active" href="index.jsp"><i class="fas fa-home"></i> Home</a>
  		<a href="contact.jsp"><i class="fas fa-id-card"></i> Contact</a>
  		<a href="about.jsp"><i class="fas fa-info"></i> About</a>
  		<a href="ViewCart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a>
  		<a href="" data-toggle="modal" data-target=".phoneList"><i class="fas fa-list"></i> Phone List</a>
  		<right>
  		<div style="padding-top: 1px; margin-top: 1px;" class="d-flex justify-content-end"> 
	  		<form class="form-inline" action="Search.jsp" method="post">
			  <div class="form-group row">
			    <div class="col-auto">
			   		<i style = "color: yellow" class="fas fa-search"></i>
			    </div>
			    <div class="col-auto">
			    	<input type="text" class="form-control" id="input" placeholder="Search Product..." name="input" required="required">
			    </div>
			    <div class="col-auto" style="padding-top: 2px; margin-top: 2px;">
			    	<button type="submit" class="btn btn-dark" style="margin:2px;">Search</button>
			    	&nbsp;&nbsp;
			    </div>
			  </div>
			</form>	
		</div>
		</right>			
	</div>
	
	<!-- Content  -->

		
		<div class="card">
		
			<h3 class="card-title" style="padding-top: 10px;"><b>&nbsp;&nbsp;Phones</b></h1>
			<hr>
			<table class="prodTable" align="center">
				<tr align="center">
				<%
					DisplayItem display = new DisplayItem();
							for(int i=1;i<=3;i++){
								display = SingletonDB.getDisplayPhone(i);
				%>	
					<td>
						<div class="picContainer">
						  <img src='<%=display.getPic()%>' width ="50%" height="50%" class="image">
						  <div class="overlay">
						    <a data-toggle="modal" data-target="#<%=i%>"><div class="text"><b><%=display.getName() %></b></div></a>
						  </div>
						</div>
					</td>
				<%
					}
				%>
				</tr>
			</table>
			
			<!-- Modal -->
			<%
			for(int i=1;i<=3;i++){
				display = SingletonDB.getDisplayPhone(i);
			%>
			<div class="modal fade" id="<%=i%>" tabindex="-1" role="dialog" aria-labelledby="<%=i%>Label" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="<%=i%>Label"><%=display.getName()%></h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <img src='<%=display.getPic()%>' width ="50%" height="50%" class="image">
			        <p style="text-indent: 50px;text-align: justify;">
			        	<%=display.getDetails() %>
			        </p>
			      </div>
			    </div>
			  </div>
			</div>
			<%
				}
			%>
		</div>
		<hr/>
		<p><i>&copy; 2021 Phone Pirates</i></p>
		<p><i>note: Hover and click on the picture.</i></p>
		<p><i>&copy; Made by: James Liam De Jesus and Juan Carlos Dulos</i></p>
	</div>
	
	<div class="modal fade phoneList" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-sm modal-dialog-centered">
	    <div class="modal-content">
	    	<div class="modal-header">
	  			<h3 style="text-align: center;">PHONE LIST:</h3>
	  			 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			     </button>
	  		</div>
	    	<div class="modal-body">
	    		<%
	    			PhoneNameRepository repository = new PhoneNameRepository();
	    			Iterator<String> repositoryIterator = repository.getIterator();
	    			while (repositoryIterator.hasNext()) {
	    				%>
	    					<justify><h6>- <%=repositoryIterator.next()%></h6></justify> 
	    				
	    				<%
	    			}
	    		%>
	    	</div>
	    </div>
	  </div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>	