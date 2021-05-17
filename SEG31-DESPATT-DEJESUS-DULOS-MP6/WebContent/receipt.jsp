
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page import="model.cart.cart"%>
<%@ page import="model.packaging.*"%>
<%@ page import="model.*"%>
<%@ page import="model.phone.PhoneNameRepository"%>
<%@ page import="utility.*"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="model.cart.*"%>
<%@ page import="java.util.ArrayList"%>
<%
	SingletonDB.checkIfPhoneTableExist();
	String shippingAddress = request.getParameter("shippingAddress");
	String customerName = request.getParameter("user");
	int count = SingletonDB.getCartRow();
	
	OrderIterator orderiter;
	OrderCartRepository orderCart = new OrderCartRepository();
	orderiter = orderCart;
	
	
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receipt</title>
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
		<h3 class="card-title" style="padding-top: 10px;"><b>&nbsp;&nbsp;Thank You!</b></h1>
		<hr>
		<table>
			<tr>
				<table class="prodTable" align="center">
					<tr align="center">
						<td>
							<img src='images/Designs/logo.png' width ="250px" height="250px" style="border-radius: 50%;opacity: 0.8;">
						</td>
						<td>
							<p style="text-align: left;">&nbsp;THANK YOU FOR YOUR PURCHASE <b>MATEY! <span style="color: red;">ARR!</span></b></p>
						</td>
					</tr>
				</table>
				
				<div>
				    <input type="hidden" class="form-control" id="shippingAddress"  name="shippingAddress" value='${shippingAddress}'>
				</div>
				
				<div class="container">
					<div class="card">
					<table>
						<tr>
							<div class="container">
							  <div class="row">
							  	<h3 style="padding-top: 1%;">&nbsp;&nbsp;Order Details: </h3>
							  </div>
							  <div class="row">
							  	<br>
							  </div>
							  <div class="row">
							  	<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Customer Name: ${user}</h5>
							  </div>
							  <div class="row">
							  	<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shipping Address: ${shippingAddress}</h5>
							  </div>
							  <div class="row">
							  	<br>
							  </div>
							  <div class="row">
							  	<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Order Number: ${orderNum}</h5>
							  </div>
					
					  		<table class="table">
					 		 <thead class="thead-dark">
					    	<tr>
					      		<th>Phone</th>
					      		<th>Quantity</th>
					      		<th>Price</th>
					      		<th>Packaging</th>
					    	</tr>
					  		</thead>
					    <tbody>
					    <tr>
					  
				<%
		  					
							
							Double totalPhonePrice = 0.0;
							Iterator<OrderCartContainer> orderIterator = orderiter.createIterator();
							
							while(orderIterator.hasNext()){
								OrderCartContainer order_cart = (OrderCartContainer) orderIterator.next();
								
								String phoneName = SingletonDB.getPhoneName(order_cart.getPhoneID());
								Double phonePrice = order_cart.getPrice();
  							    int phoneQuantity = order_cart.getQuantity();
  							    totalPhonePrice = order_cart.getTotalPrice();
  							  	ArrayList<String> PhoneSetMsg = new ArrayList();
							  	String packagingInfo = "";
							  	ItemSetBuilder phoneSetBuilder = new ItemSetBuilder();
							  	
							  	 //if statements for builder 
	  							if(phoneName.equalsIgnoreCase("IPHONE 12 PRO")) {
	  								
	  								ItemSet IphoneSet = phoneSetBuilder.IphoneSetBuilder(phoneName);
									System.out.println("Iphone Set qty: " + order_cart.getQuantity());
									IphoneSet.showItems();
								    System.out.println("Total Cost: " + IphoneSet.getCost());
								    
								    PhoneSetMsg = IphoneSet.showItemsJsp();
								    Iterator<String> itr = PhoneSetMsg.iterator();
								    
								    packagingInfo = "Phone set Includes: <br>";
								    
								    while(itr.hasNext()) {
								    	packagingInfo = packagingInfo + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  itr.next();
								    }

	  							    
	  							} else if(phoneName.equalsIgnoreCase("SAMSUNG GALAXY S20")) {
	  					   			        
	  								ItemSet S20Set = phoneSetBuilder.S20SetBuilder(phoneName);
									System.out.println("Iphone Set qty: " + order_cart.getQuantity());
									S20Set.showItems();
								    System.out.println("Total Cost: " + S20Set.getCost());
								    
								    PhoneSetMsg = S20Set.showItemsJsp();
								    Iterator<String> itr = PhoneSetMsg.iterator();
								    
								    packagingInfo = "Phone set Includes: <br>";
								    
								    while(itr.hasNext()) {
								    	packagingInfo = packagingInfo + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  itr.next();
								    }
	  					   			        
	  							} else if(phoneName.equalsIgnoreCase("HUAWEI P30 LITE")) {
	  								
	  								ItemSet P30Set = phoneSetBuilder.P30SetBuilder(phoneName);
	  								System.out.println("Iphone Set qty: " + order_cart.getQuantity());
	  								P30Set.showItems();
								    System.out.println("Total Cost: " + P30Set.getCost());
								    
								    PhoneSetMsg = P30Set.showItemsJsp();
								    Iterator<String> itr = PhoneSetMsg.iterator();
								    
								    packagingInfo = "Phone set Includes: <br>";
								    
								    while(itr.hasNext()) {
								    	packagingInfo = packagingInfo + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  itr.next();
								    }
	  								
	  							}
		  					
							  	phonePrice = phonePrice*phoneQuantity;
					%>
					  
					
					      <td><%= phoneName %></td>
					      <td><%= phoneQuantity %></td>
					      <td>PHP. <%= phonePrice %>0</td>
					      <td><%= packagingInfo  %></td>
					    </tr>
					  
					  <%
						}
				
						for(int i = 1; i<=count; i++) {
							SingletonDB.removeCartItem(i);
						}
						
					  %>
				</tbody>
			</table>
				  <div class="row">
				  	<div class="col">
				  		<p style="text-align: justify;"><b>&nbsp;&nbsp;Total Price:</b> &nbsp;&nbsp;PHP <%= totalPhonePrice %>0</p>
				  	</div>
				  </div>
				</div>
			</tr>
		</table>
		<div>
		</br>
			<form class="form-inline" action="index.jsp" method="post">
					 &nbsp;&nbsp;<button type="submit" class="btn btn-danger mb-2">Go Back</button>
			</form>	
		</div>
	<hr/>
		<p><i>&copy; 2021 Phone Pirates</i></p>
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