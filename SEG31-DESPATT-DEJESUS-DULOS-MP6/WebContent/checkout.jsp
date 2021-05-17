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
<title>Checkout</title>
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
	<!-- ADD EXPIRATION DATE CHECKER AND EMAIL SEND AND PDF IN THE CHECKOUT.ACTION -->
	<div class="card">
		<h3 class="card-title" style="padding-top: 10px;"><b>&nbsp;&nbsp;Checkout</b></h3>
		<hr>
		<table>
			<tr>
				<div class="container">
				  <form id="Form"  action="checkout.action" method="post">
				  
					  <div class="row" align="center">
					  	<div class="col-3">
					  	</div>
					    <div class="col-7">
					     	<h5><b>Owner Name: </b><input type="text" class="form-control" id="user"  name="user" required="required" onkeyup="formload()"></h5>
					    </div>
					  </div>
					  
					  <div class="row" align="center">
					  	<div class="col-3">
					  	</div>
					    <div class="col-7">
					     	<h5><b>Shipping Address: </b><input type="text" class="form-control" id="shippingAddress"  name="shippingAddress" required="required" onkeyup="formload()"></h5>
					    </div>
					  </div>
					  
					  <div class="row" align="center">
					  	<div class="col-3">
					  	</div>
					  	<div class="col-4">
					    	<p style="text-align: justify;"><b>Email: </b><input type="email" class="form-control" id="email"  name="email" required="required" onkeyup="formload()"></p>
					    </div>
					  	
					    <div class="col-3">
					     	<h5><b>Expiration Date: </b><input type="date" class="form-control" id="expirationDate"  name="expirationDate" required="required"maxlength=10 onchange="formload()"></h5>
					    </div>
					  </div>
					  
					  <div class="row" align="center">
					  	<div class="col-3">
					  	</div>
					    <div class="col-4">
					    	<p style="text-align: justify;"><b>Credit Card Number: </b>
					    	<input type="text" class="form-control" id="ccNumber"  name="ccNumber" required="required" onkeyup="formload()"></p>
					    </div>
					    <div class="col-3">
					    	<p style="text-align: justify;"><b>CCV: </b><input type="text" class="form-control" id="ccv"  name="ccv" required="required" minlength=3 maxlength=4 onkeyup="formload()"></p>
					    </div>
					  </div>
					  
					  <div class="row">
					  	<br>
					  </div>
					  <div class="row">
				  		<div class="col">
				  			<button type="submit" class="btn btn-success" style="margin:2px;" id="btnSubmit" onclick="manage()" disabled="disabled">Proceed Checkout</button> 
				  			<label id="lblwait" style="visibility: hidden"><span style="color: red;" >Please wait while we are sending the receipt to your email....</span></label>
				  		</div>
				  		<br><br>
				  	</div>
			  	</form>
			  	<form class="form-inline" action="cancel.action" method="post">
				  <div class="form-group row">
				    <div class="col-auto">
				    	<button type="submit" class="btn btn-danger mb-2" id="btnCancel">Cancel</button>
				    </div>
				  </div>
				</form>	
				</div>
			</tr>
		</table>
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
<script>
	
	function formload(){
		var bt = document.getElementById('btnSubmit');
		var input_user = document.getElementById('user');
		var input_ccv = document.getElementById('ccv');
		var input_ccNumber = document.getElementById('ccNumber');
		var input_expirationDate = document.getElementById('expirationDate');
		var input_email = document.getElementById('email');
		var input_shippingAddress = document.getElementById('shippingAddress');
		
		if(input_user.value != ""){
			if(input_shippingAddress != ""){
				if(input_ccv.value != ""){
					if(input_ccNumber.value != ""){
						if(input_email.value != ""){
							if(input_expirationDate.value != ""){
								bt.disabled = false;
							}
						}
					}
				}
			}
		}
	}
	
	
	
	function manage() {     
		var btnCancel = document.getElementById('btnCancel');
		var form = document.getElementById('Form');
	    var bt = document.getElementById('btnSubmit');
	    var lbl = document.getElementById('lblwait');
	    bt.disabled = true;
	    btnCancel.disabled = true;
	    lbl.style.visibility = "visible";
	    btnCancel.style.visibility = "hidden";
	    form.submit();
	}
	
</script>
</body>
</html>