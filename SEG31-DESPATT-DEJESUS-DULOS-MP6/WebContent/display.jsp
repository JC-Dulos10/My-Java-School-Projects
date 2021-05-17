<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="model.*"%>
<%@ page import="model.phone.PhoneNameRepository"%>
<%@ page import="utility.*"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.packaging.*"%>

<%
	SingletonDB.checkIfPhoneTableExist();
	ArrayList<String> PhoneSetMsg = new ArrayList();
	String packagingInfo = "";
	ItemSetBuilder phoneSetBuilder = new ItemSetBuilder();	
	String phoneName = request.getParameter("input");
	
	//if statements for builder 
	if(phoneName.equalsIgnoreCase("IPHONE 12 PRO")) {
		
		ItemSet IphoneSet = phoneSetBuilder.IphoneSetBuilder(phoneName);
	    PhoneSetMsg = IphoneSet.showItemsJsp();
	    Iterator<String> itr = PhoneSetMsg.iterator();
	    
	    packagingInfo = "";
    
	    while(itr.hasNext()) {
	    	packagingInfo = packagingInfo + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  itr.next();
	    }

	    
	} else if(phoneName.equalsIgnoreCase("SAMSUNG GALAXY S20")) {
			        
		ItemSet S20Set = phoneSetBuilder.S20SetBuilder(phoneName);
	    PhoneSetMsg = S20Set.showItemsJsp();
	    Iterator<String> itr = PhoneSetMsg.iterator();
	    
	    packagingInfo = "";
	    
	    while(itr.hasNext()) {
	    	packagingInfo = packagingInfo + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  itr.next();
	    }
			        
	} else if(phoneName.equalsIgnoreCase("HUAWEI P30 LITE")) {
		
		ItemSet P30Set = phoneSetBuilder.P30SetBuilder(phoneName);
	    PhoneSetMsg = P30Set.showItemsJsp();
	    Iterator<String> itr = PhoneSetMsg.iterator();
	    
	    packagingInfo = "";
	    
	    while(itr.hasNext()) {
	    	packagingInfo = packagingInfo + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  itr.next();
	    }
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${Name}</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/f7015e5bbd.js" crossorigin="anonymous"></script>
</head>
<body onload="manage()">

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
		<div class="card">
			<h3 class="card-title" style="padding-top: 10px;"><b>&nbsp;&nbsp;Products</b></h1>
			<hr>
			<table>
				<tr>
					<div class="container">
					  <div class="row">
					    <div class="col">
					     	<h5 class="prodName"><b>${Name}</b></h3>
					     	<img src='${Pic}' width ="100px" height="100px" class="image">
					    </div>
					    <div class="col">
					    	<p style="text-align: justify;"><b>Details:</b> &nbsp;&nbsp;${Details}</p>
					    	<p style="text-align: justify;"><b>This includes:</b> &nbsp;&nbsp;<%=packagingInfo%></p>
					    </div>
					    <div class="col">
					    	<p style="text-align: justify;"><b>Camera:</b> &nbsp;&nbsp;<s:property value="cam"/></p>
					    	<br><br><br><br><br><br><br>
					    	<p style="text-align: justify;"><b>Available stock: &nbsp;&nbsp;${inventory}</b></p>
					    	<p style="text-align: justify;"><b>Price: &nbsp;&nbsp;PHP. ${Price}0</b></p>
					    </div>
					  </div>
					</div>
				</tr>
			</table>
			<div class="container">
				<form class="form-inline" action="add.action" method="post">
					<h6><b>Qty:</b></h6> &nbsp; 
					<input type="number" class="form-control-sm" id="quantity"  name="quantity" required="required" min=1 max='${inventory}'> &nbsp;
					<button type="submit" class="btn btn-dark btn-block-sm" style="margin:2px;" id="btnSubmit">Add to Cart</button>
					<label id="lblquantity"><span style="color: red;">Out of Stock!</span></label>
					
					<input type="hidden" class="form-control" id="phone_id"  name="phone_id" value='${phone_id}'>
					<input type="hidden" class="form-control" id="Price"  name="Price" value='${Price}'>
					<input type="hidden" class="form-control" id="inventory"  name="inventory" value='${inventory}'>
					<input type="hidden" class="form-control" id="input"  name="input" value='${input}'>
				
				</form>
			</div>
			<div class = "row">
				<div class = "col">
	   				<form action="index.jsp" method="post">
					&nbsp;&nbsp;<button type="submit" class="btn btn-danger mb-2">Go Back</button>
				</form>
				</div>
			</div>
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
function manage() {
	var max = document.getElementById("quantity").max;
    var bt = document.getElementById('btnSubmit');
    var lbl = document.getElementById('lblquantity');
    if (max == 0) {
        bt.disabled = true;
        lbl.style.visibility = "visible";
    }
    else {
        bt.disabled = false;
        lbl.style.visibility = "hidden";
    }
}
</script>
</body>
</html>	