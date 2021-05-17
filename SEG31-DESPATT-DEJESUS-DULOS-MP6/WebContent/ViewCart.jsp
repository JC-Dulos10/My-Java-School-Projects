<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page import="model.cart.cart"%>
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
<title>View Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/f7015e5bbd.js" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container" width="120%">
	<!-- TOP  -->
	<table class="banner">
		<th><img src='images/Designs/logo.png' class = "logo" width="150" height="150"></th>
		<th></th>
		<th><span class="ShopName">Phone Pirates</span></th>
	</table>
	
	<!-- navbar  -->
	<div class="navibar">
  		<a href="index.jsp"><i class="fas fa-home"></i> Home</a>
  		<a href="contact.jsp"><i class="fas fa-id-card"></i> Contact</a>
  		<a href="about.jsp"><i class="fas fa-info"></i> About</a>
  		<a class="active" href="ViewCart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a>
  		<a href="" data-toggle="modal" data-target=".phoneList"><i class="fas fa-list"></i> Phone List</a>
  		<right>
  		<div style="padding-top: 1px; margin-top: 1px;" class="d-flex justify-content-end"> 
	  		<form class="form-inline" action="Search.jsp" method="post">
			  <div class="form-group row">
			    <div class="col-auto">
			   		<h5 style="color: #ffcc00"><b>&nbsp;Search:</b></h3>
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
		
			<h3 class="card-title" style="padding-top: 10px;"><b>&nbsp;&nbsp;Products</b></h3>
			<hr>
			<h5 class="card-title" style="padding-top: 10px;"><b>&nbsp;&nbsp;Cart:</b></h5>
			<%
			Double totalPrice = 0.0;
			int count = SingletonDB.getCartRow();
			if(count == 0) {
			%>
			<table cellspacing="20px">
			<tr>
				<form class="form-inline" action="index.jsp" method="post">
				  <div class="form-group row">
				    <div class="col-auto">
				   		<h5 style="color: red"><b>&nbsp;&nbsp;&nbsp;&nbsp;CART EMPTY...</b></h3>
				    </div>
				    <div class="col-auto">
				    	<button type="submit" class="btn btn-danger mb-2">Go Back</button>
				    </div>
				  </div>
				</form>						
			</tr>
			</table>
			<% 
			} else {
				for(int i = 1; i<=count; i++) {
					cart cartUser = SingletonDB.getCartData(i);
					if(SingletonDB.getCartData(i) != null){
						String name = SingletonDB.getPhoneName(cartUser.getPhoneID());
						totalPrice = cartUser.getTotalPrice();
			%>
			<table>
				<tr>
					<div class="container">
					  <div class="row" align="center">
					  <form action="remove.action" method="post">
					    <div class="col-2">
					     	<h5><b>ID: </b><%= cartUser.getId() %></h5>
					    </div>
					    <div class="col-3">
					    	<p style="text-align: justify;"><b>Phone: </b><%= name %></p>
					    </div>
					    <div class="col-2">
					    	<p style="text-align: justify;"><b>Quantity:</b> <%= cartUser.getQuantity() %></p>
					    </div>
					    <div class="col-2">
					    	<p style="text-align: justify;"><b>Price:</b> PHP <%= cartUser.getPrice() %>0</p>
					    </div>
					    <div class="col-3">
							<button type="submit" class="btn btn-danger" style="margin:2px;">Remove to cart</button> 
					    </div>
					    <div>
					    	<input type="hidden" class="form-control" id="cart_id"  name="cart_id" value='<%= cartUser.getId()%>'>
					    	<input type="hidden" class="form-control" id="phone_id"  name="phone_id" value='<%= cartUser.getPhoneID()%>'>
					    	<input type="hidden" class="form-control" id="Price"  name="Price" value='<%= cartUser.getPrice()%>'>
					    	<input type="hidden" class="form-control" id="quantity"  name="quantity" value='<%= cartUser.getQuantity()%>'>
					    	<input type="hidden" class="form-control" id="totalPrice"  name="totalPrice" value='<%= totalPrice%>'>
			    		</div>
					  </form>	
					  </div>
					  <div class="row">
					  	<br>
					  </div>
					  <%
							}
						}
					  %>
					  <div class="row">
					  	<div class="col">
					  		<p style="text-align: justify;"><b>Total Price:</b> &nbsp;&nbsp;PHP <%= totalPrice %>0</p>
					  	</div>
					  </div>
					  <div class="row">
					  	<form action="checkout.jsp" method="post">
					  		<div class="col">
					  			<button type="submit" class="btn btn-success" style="margin:2px;">Proceed Payment</button> 
					  		</div>
					  		<br><br>
				  		</form>
				  	</div>
				</div>
				</tr>
			</table>
			<%
				
			}
			%>
		</div>
		
	</fieldset>
	<hr/>
	<p><i>&copy; 2021 Phone Pirates</i></p>
	<p><i>&copy; Made by: James Liam De Jesus and Juan Carlos Dulos</i></p>
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