package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

import model.ItemCamera.HuaweiP30LiteCamera;
import model.ItemCamera.Iphone12ProCamera;
import model.ItemCamera.ItemCamera;
import model.ItemCamera.SamsungGalaxyS20Camera;
import model.cart.OrderCartContainer;
import model.cart.OrderCartRepository;
import model.cart.OrderIterator;
import model.cart.cart;
import model.packaging.ItemSet;
import model.packaging.ItemSetBuilder;
import model.phone.HuaweiP30Lite;
import model.phone.Iphone12Pro;
import model.phone.Phones;
import model.phone.SamsungGalaxyS20;
import utility.ItemCameraFactory;
import utility.PhoneDeviceFactory;
import utility.SingletonDB;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.CellEditor;

import org.apache.struts2.interceptor.ServletRequestAware;
import javax.servlet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import utility.*;

public class UserActionServlet extends ActionSupport implements Facade, ServletRequestAware{
	
	public HttpServletRequest request;
	
	//Variables for displaying search
	private String input;
	private String Pic;
	private Double Price;
	private String Details;
	private String Name;
	private String cam;
	private Double totalPrice;
	private int cart_id;
	private int phone_id;
	private int orderNum;
	private int inventory;
	
	//variables for add
	private int quantity;
	
	//variables for user
	private String user;
	private String ccv;
	private String ccNumber;
	private String expirationDate;
	private String email;
	private String shippingAddress;
	private Boolean isValid = null;
	private String errorMsg = null;
	
	
	//execute as required by actionclass
	//searching phone
	public String search() {	
		searchProdSetProcess();
		return SUCCESS;
	}
	
	//Add cart
	public String add() {
		addToCart();
		return SUCCESS;
	}
	
	//remove cart
	public String remove() {
		removeToCart();
		return SUCCESS;
	}
	
	//checkout
	public String checkout() {
		if(checkoutItems()) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String cancel() {
		cancelOrder();
		return SUCCESS;
	}
	
	//setter and getters
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getPic() {
		return Pic;
	}
	public void setPic(String pic) {
		Pic = pic;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCam() {
		return cam;
	}
	public void setCam(String cam) {
		this.cam = cam;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
 	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCcv() {
		return ccv;
	}
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	//Facade functions
	//Creating clone and for the searching
	@Override
	public Boolean searchProdSetProcess(){
		
		System.out.println("User Input: " + this.input);
		
		boolean isSuccess;
		input = input.toUpperCase();
		// TODO Auto-generated method stub
		if(SingletonDB.checkPhoneExist(input)){
			
			System.out.println("inside if...");
			isSuccess = true;
			Phones phone = new PhoneDeviceFactory().PhoneModel(input);
			ItemCamera PhoneCamera  = new ItemCameraFactory().getPhoneCameraDetails(input);
			phone.setCamera(PhoneCamera);
			
			if (phone instanceof Iphone12Pro) {
					
				Iphone12Pro Iphone12Pro = (Iphone12Pro) phone;
				Iphone12ProCamera Iphone12ProCam = (Iphone12ProCamera) phone.getCamera();
				
				Iphone12Pro.setValues(input);
				
				Iphone12ProCam.SetCameraDetails(input);
				
				this.Name = Iphone12Pro.getName();
				this.Details = Iphone12Pro.getDetails();
				this.Price = Iphone12Pro.getPrice();
				this.Pic = Iphone12Pro.getPic();
				this.cam = Iphone12ProCam.getDetails();
				this.phone_id = Iphone12Pro.getId();
				this.inventory = Iphone12Pro.getInventory();
				
					
			} else if (phone instanceof SamsungGalaxyS20) {
					
				SamsungGalaxyS20 SamsungGalaxyS20 = (SamsungGalaxyS20) phone;
				SamsungGalaxyS20Camera SamsungGalaxyS20Cam = (SamsungGalaxyS20Camera) phone.getCamera();
				
				SamsungGalaxyS20.setValues(input);
				
				SamsungGalaxyS20Cam.SetCameraDetails(input);
				
				this.Name = SamsungGalaxyS20.getName();
				this.Details = SamsungGalaxyS20.getDetails();
				this.Price = SamsungGalaxyS20.getPrice();
				this.Pic = SamsungGalaxyS20.getPic();
				this.cam = SamsungGalaxyS20Cam.getDetails();
				this.phone_id = SamsungGalaxyS20.getId();
				this.inventory = SamsungGalaxyS20.getInventory();
				
			} else if (phone instanceof HuaweiP30Lite) {
				
				HuaweiP30Lite HuaweiP30Lite = (HuaweiP30Lite) phone;
				HuaweiP30LiteCamera HuaweiP30LiteCam = (HuaweiP30LiteCamera) phone.getCamera();
				
				HuaweiP30Lite.setValues(input);
				
				HuaweiP30LiteCam.SetCameraDetails(input);
				
				this.Name = HuaweiP30Lite.getName();
				this.Details = HuaweiP30Lite.getDetails();
				this.Price = HuaweiP30Lite.getPrice();
				this.Pic = HuaweiP30Lite.getPic();
				this.cam = HuaweiP30LiteCam.getDetails();
				this.phone_id = HuaweiP30Lite.getId();
				this.inventory = HuaweiP30Lite.getInventory();
				
			}
			System.out.println("id: " +  this.phone_id);
			System.out.println("Name: " +  this.Name);
			System.out.println("Pic Dir: " +  this.Pic);
			System.out.println("Price: " +  this.Price);
			System.out.println("Details: " +  this.Details);
			System.out.println("Camera Details: " +  this.cam);
			System.out.println("Inventory: " +  this.inventory);
			System.out.println("\nUser Input: " + this.input);
		} else {
			isSuccess = false;
		}
		return isSuccess;
	}

	//Adding items to cart
	@Override
	public void addToCart() {
		// TODO Auto-generated method stub
		this.totalPrice = 0.0;
		System.out.println("ADD");
		System.out.println("id: " +  this.phone_id);
		System.out.println("Price: " +  this.Price);
		System.out.println("Inventory: " +  this.inventory);
		System.out.println("\nUser Input: " + this.input);
		int inventoryUpdated = this.inventory - this.quantity;
		System.out.println("Quantity selected is: " + quantity);
		System.out.println("Updated inventory is: " + inventoryUpdated);
		
		SingletonDB.updateQty(this.phone_id, inventoryUpdated);
		int count = SingletonDB.getCartRow();
		System.out.println("ROW COUNT: " + count);
		int rowCount = SingletonDB.getCartRowNum();
		if(rowCount == 0) {
			totalPrice = this.Price*this.quantity;
			this.cart_id = SingletonDB.addToCart(phone_id, quantity, Price, totalPrice, this.orderNum);
		} else {
			boolean isUpdated = false;
			for(int i = 1; i<=count; i++) {
				if(SingletonDB.getCartData(i) != null) {
					cart cart = SingletonDB.getCartData(i);
					System.out.println("Cart phoneID: " + cart.getPhoneID());
					System.out.println("Input phoneID: " + this.phone_id);
					if(cart.getPhoneID() == this.phone_id) {
						System.out.println("additional qty: " + this.quantity);
						totalPrice = cart.getTotalPrice() + (this.Price*this.quantity);
						this.quantity = cart.getQuantity() + this.quantity;
						System.out.println("Same CartQty: "+this.quantity);
						System.out.println("Same ID Cart: "+this.cart_id);
						SingletonDB.updateCartPhoneQuantity(this.phone_id, this.quantity);
						isUpdated =true;
					} else if(isUpdated == false) {
						System.out.println("TOTAL PRICE INPUT: "+quantity*Price);
						totalPrice = cart.getTotalPrice();
						System.out.println("Cart Total Price: " + this.totalPrice);
						totalPrice = totalPrice + (quantity*Price);
					}
				}
			}
			if(isUpdated == false) {
				this.cart_id = SingletonDB.addToCart(phone_id, quantity, Price, totalPrice, this.orderNum);
				System.out.println("Cart ID for Order No.: " + this.cart_id);
				System.out.println("Order ID: " + this.orderNum);
			}
			System.out.println("Updated Total Price is: " + this.totalPrice);
			for(int i = 1; i<=count; i++) {
				if(SingletonDB.getCartData(i) != null) {
					SingletonDB.updateTotalPrice(this.totalPrice, i);
				}
			}
		}
	}

	//Remove items in the Cart
	@Override
	public void removeToCart() {
		// TODO Auto-generated method stub
		this.inventory = SingletonDB.getInventory(phone_id);
		System.out.println("Remove item ID: " + this.cart_id + " from cart...");
		this.totalPrice = this.totalPrice - (this.Price*this.quantity);
		int count = SingletonDB.getCartRow();
		System.out.println("Updated Total Price is: " + this.totalPrice);
		for(int i = 1; i<=count; i++) {
			SingletonDB.updateTotalPrice(this.totalPrice, i);
		}
		int inventoryUpdated = this.inventory + this.quantity;
		System.out.println("Inventory selected is: " + this.inventory);
		System.out.println("Phone ID selected is: " + this.phone_id);
		System.out.println("Quantity selected is: " + quantity);
		System.out.println("Updated inventory is: " + inventoryUpdated);
		System.out.println("Phone Id: " + this.phone_id);
		SingletonDB.updateQty(this.phone_id, inventoryUpdated);
		SingletonDB.removeCartItem(cart_id);
	}

	//Checkout
	@Override
	public Boolean checkoutItems() {
		// TODO Auto-generated method stub
		int count = SingletonDB.getCartRow();
		this.ccNumber = ccNumber.replaceAll("\\s+", "");
		System.out.println("ROW COUNT: " + count);
		System.out.println("Checkout...");
		System.out.println("Owner: "+this.user);
		System.out.println("CCV: "+this.ccv);
		System.out.println("Credit Card Number: "+this.ccNumber);
		System.out.println("Expiration date: "+this.expirationDate);
		System.out.println("Email: "+this.email);
		System.out.println("Shipping Address: "+ this.shippingAddress);
		
		if(luhnTest(ccNumber)) {
			if(isNumeric(this.ccv)){
				if(isLengthValid(this.ccv)) {
					if(isExpired() == false)
					{
						
						this.orderNum = SingletonDB.insertOrder(this.user, this.email, this.shippingAddress, "Sending order to the Seller");
						for(int i = 1; i<=count; i++) {
							if(SingletonDB.getCartData(i) != null){
								SingletonDB.updateOrderNumCart(orderNum, i);
							}
						}
						ItemSetBuilder phoneSetBuilder = new ItemSetBuilder();
						
						this.isValid = true;
						System.out.println("is it credit card is Valid: "+ this.isValid);
						String pdfLoc = createPDF();
	
						sendEmail(pdfLoc);
						
						for(int i = 1; i<=count; i++) {
							if(SingletonDB.getCartData(i) != null) {
								
								cart cart = SingletonDB.getCartData(i);
								this.Name = SingletonDB.getPhoneName(cart.getPhoneID());
								
								if(this.Name.equalsIgnoreCase("IPHONE 12 PRO")) {
									
									ItemSet IphoneSet = phoneSetBuilder.IphoneSetBuilder(this.Name);
									IphoneSet.showItems();
								    System.out.println("Total Cost: " + IphoneSet.getCost()*cart.getQuantity());
								    System.out.println("per set Cost: " + IphoneSet.getCost());
								    
								} else if(this.Name.equalsIgnoreCase("SAMSUNG GALAXY S20")) {
									
									ItemSet S20Set = phoneSetBuilder.S20SetBuilder(this.Name);
									System.out.println("SAMSUNG GALAXY S20 Set");
									S20Set.showItems();
								    System.out.println("Total Cost: " + S20Set.getCost()*cart.getQuantity());
								    System.out.println("per set Cost: " + S20Set.getCost());
								    
								} else if(this.Name.equalsIgnoreCase("HUAWEI P30 LITE")) {
									
									ItemSet P30Set = phoneSetBuilder.P30SetBuilder(this.Name);
									System.out.println("HUAWEI P30 LITE Set");
									P30Set.showItems();
								    System.out.println("Total Cost: " + P30Set.getCost()*cart.getQuantity());
								    System.out.println("per set Cost: " + P30Set.getCost());
								    
								}
							    SingletonDB.addToOrderCart(cart.getPhoneID(), cart.getQuantity(), cart.getPrice(), cart.getTotalPrice(), cart.getOrderNum());
							}
						}
					} else {
						this.isValid = false;
						errorMsg = "Card Expired...";
						System.out.println("is it Valid: " + this.isValid);
					}
				} else {
					this.isValid = false;
					errorMsg = "CCV is invalid length...try again";
					System.out.println("is it Valid: " + this.isValid);
				}
			} else {
				this.isValid = false;
				errorMsg = "CCV is invalid...must be numeric";
				System.out.println("is it Valid: " + this.isValid);
			}
		} else {
			this.isValid = false;
			System.out.println("is it Valid: " + this.isValid);
			errorMsg = "Credit Card Number is invalid";
		}
		return isValid;
	}
            
	//Checkers
	//luhn algo given code
	@Override
	 public Boolean luhnTest(String number){
	    int s1 = 0, s2 = 0;
	    String reverse = new StringBuffer(number).reverse().toString();
	    for(int i = 0 ;i < reverse.length();i++){
	        int digit = Character.digit(reverse.charAt(i), 10);
	        if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
	        s1 += digit;
	        }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
	             s2 += 2 * digit;
	             if(digit >= 5){
	                 s2 -= 9;
	             }
	         }
	     }
	     return (s1 + s2) % 10 == 0;
	 }

	//check if ccv is numeric
	@Override
	 public Boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	 
	//check if length
	@Override
	public Boolean isLengthValid(String num) {
		 if(num.length() == 3 || num.length() == 4) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 //check expiration date
	@Override
	 public Boolean isExpired(){
	     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     LocalDate now = LocalDate.now();
	     String presentDate = dtf.format(now);
	     System.out.println("Date today: "+ presentDate);
	     
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     
	     try {
			Date present = (Date) sdf.parse(presentDate);
			Date expDate = (Date) sdf.parse(expirationDate);
			if(expDate.compareTo(present)<=0) {
				return true;
			} else {
				 return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return true;
	 }
	
	//generate PDF
	//PDF related methods
	@Override
	public String createPDF() {

		int count = SingletonDB.getCartRow();	
		Rectangle pageSize = new Rectangle(500, 700);
		pageSize.setBackgroundColor(new BaseColor(255,235,205));
		Document document = new Document(pageSize);
		String filePath = request.getServletContext().getRealPath("/");
		System.out.println("\n\nFile directory: " + filePath +"\n\n");
		String pdfLoc = filePath +"Receipt/Order"+ new java.util.Date().getTime() + ".pdf";
		

		
			try {
				
				PdfWriter.getInstance(document,
	                       new FileOutputStream(filePath+"Receipt/Order"+ new java.util.Date().getTime() + ".pdf"));	
				
			   document.open();
			   Paragraph spaces = new Paragraph("\n\n\n");
			   Paragraph space = new Paragraph("\n");
			   Image logo = Image.getInstance(filePath+"images/Designs/logo.png");
		       logo.scaleAbsolute(150f, 150f);
		       logo.setAlignment(Element.ALIGN_CENTER);
		       Paragraph OwnerName = new Paragraph("Customer Name: " + this.user, FontFactory.getFont(FontFactory.TIMES_BOLD, 18)); 
		       Paragraph titleReceipt = new Paragraph("The Phone Pirates!" + "\nOfficial Receipt\n" , FontFactory.getFont(FontFactory.TIMES_BOLD, 24));
		       titleReceipt.setAlignment(Element.ALIGN_CENTER);
		       Paragraph ShippingAddress = new Paragraph("Customer Shipping Address: " + this.shippingAddress, FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
		       Paragraph thankYouMessage = new Paragraph(
		    		  "Thank You For Purchasing at Phone Pirates! We Hope You Visit Us Again! ",  FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
		       thankYouMessage.setAlignment(Element.ALIGN_CENTER);
		       Paragraph orderItemsTitle = new Paragraph("Order:"+this.orderNum+"\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 24));
		       Paragraph programmersNames = new Paragraph(
		    		  "\n\nProgrammer Name: Juan Carlos C. Dulos" + ""
		    		  		+ "\nProgrammer Name: James Liam De jesus", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
		       Paragraph endingMSg = new Paragraph("	\r\n"
			      		+ " The Phone Pirates sells authentic, high quality brand new phones.\r\n"
			      		+ "~Aye ~Aye Ahoy, time to buy some new phones....",FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
		       endingMSg.setAlignment(Element.ALIGN_CENTER);
		      
		       Image programmerPic = Image.getInstance(filePath+"images/Designs/pair.jpg");
		       programmerPic.setRotationDegrees(180f);
		       programmerPic.scaleAbsolute(150f, 150f);
		       programmerPic.setAlignment(Element.ALIGN_CENTER);
 
		       document.add(logo);
		       document.add(space);
		       document.add(spaces);
		       document.add(titleReceipt);
		       document.add(spaces);
		       document.add(spaces);
		       document.add(OwnerName);
		       document.add(space);
		       document.add(ShippingAddress);
		       document.newPage();
		       document.add(space);
		       document.add(orderItemsTitle);
		      
		       PdfPTable table = new PdfPTable(4);
		      
		       PdfPCell cl = new PdfPCell(new Phrase("Phone Name: ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12)));
		       table.addCell(cl);
              
               cl = new PdfPCell(new Phrase("Phone Price: ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12)));
               table.addCell(cl);
 
               cl = new PdfPCell(new Phrase("Quantity: ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12)));
               table.addCell(cl);
               
               cl = new PdfPCell(new Phrase("Packaging: ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12)));
               table.addCell(cl);
               
               table.setHeaderRows(1);
 
               OrderIterator orderiter;
	   	  	   OrderCartRepository orderCart = new OrderCartRepository();
	 	  	   orderiter = orderCart;
		       String phoneName = "";
		       int phoneID = 0;
		       String pic = "";
		       double phonePrice = 0.0;
		       int phoneQuantity = 0;
		       double totalPrice = 0.0;
		       ArrayList<String> PhoneSetMsg = new ArrayList();
		       ItemSetBuilder phoneSetBuilder = new ItemSetBuilder();
		       Iterator<OrderCartContainer> orderIterator = orderiter.createIterator();
		       
		       while(orderIterator.hasNext()){
		     	  OrderCartContainer order_cart = (OrderCartContainer) orderIterator.next();
		    	  phoneQuantity = order_cart.getQuantity();
            	  phoneName = SingletonDB.getPhoneName(order_cart.getPhoneID());
            	  Phrase Package_message = new Phrase("");
            	  String phone_set_message = "";
            	  if(phoneName.equalsIgnoreCase("IPHONE 12 PRO")) {
						
            		  ItemSet IphoneSet = phoneSetBuilder.IphoneSetBuilder(phoneName);
					    PhoneSetMsg = IphoneSet.showItems();
					    Iterator<String> itr = PhoneSetMsg.iterator();
					    while(itr.hasNext()) {
					    	phone_set_message = phone_set_message + "\n" +  itr.next();
					    }

					    //Setting values
					    phonePrice = order_cart.getPrice();
					    pic = SingletonDB.getPhonePic(order_cart.getPhoneID());
					    Package_message = new Phrase(phone_set_message, FontFactory.getFont(FontFactory.COURIER, 8));
					    
					} else if(phoneName.equalsIgnoreCase("SAMSUNG GALAXY S20")) {
						
						ItemSet S20Set = phoneSetBuilder.S20SetBuilder(phoneName);
					    PhoneSetMsg = S20Set.showItems();
					    Iterator<String> itr = PhoneSetMsg.iterator();
					    while(itr.hasNext()) {
					    	phone_set_message = phone_set_message + "\n" +  itr.next();
					    }
 
					    //Setting values
					    phonePrice = order_cart.getPrice();
					    pic = SingletonDB.getPhonePic(order_cart.getPhoneID());
					    Package_message = new Phrase(phone_set_message, FontFactory.getFont(FontFactory.COURIER, 8));

					} else if(phoneName.equalsIgnoreCase("HUAWEI P30 LITE")) {
						ItemSet P30Set = phoneSetBuilder.P30SetBuilder(phoneName);
					    PhoneSetMsg = P30Set.showItems();
					    Iterator<String> itr = PhoneSetMsg.iterator();
					    while(itr.hasNext()) {
					    	phone_set_message = phone_set_message + "\n" +  itr.next();
					    }
					    
					    //Setting values
					    phonePrice = order_cart.getPrice();
					    pic = SingletonDB.getPhonePic(order_cart.getPhoneID());
					    Package_message = new Phrase(phone_set_message, FontFactory.getFont(FontFactory.COURIER, 8));

					}
            	  
               	   phonePrice = phonePrice*phoneQuantity;
                   totalPrice = order_cart.getTotalPrice();    
                   Phrase PhoneName = new Phrase("\n"+ phoneName, FontFactory.getFont(FontFactory.TIMES_BOLD, 10));
   			       String picFile = filePath+pic;
   			       Image phoneImg = Image.getInstance(picFile);
   			       Phrase PhonePrice = new Phrase("\nPHP." + phonePrice+"0", FontFactory.getFont(FontFactory.TIMES_BOLD, 10));
   			       Phrase PhoneQuantity = new Phrase("\n"+phoneQuantity, FontFactory.getFont(FontFactory.TIMES_BOLD, 10));
   			      
			       table.addCell(PhoneName);
			       table.addCell(PhonePrice);
			       table.addCell(PhoneQuantity);
			       table.addCell(Package_message);
		      }
		      
		      Paragraph totalPriceMsg = new Paragraph(
		    		  "Total price: PHP. " + totalPrice +"0", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
		      
		      document.add(table);
		      document.add(totalPriceMsg);
		      document.newPage();
		      document.add(spaces);
		      document.add(space); 
		      document.add(thankYouMessage);
		      programmersNames.setAlignment(Element.ALIGN_CENTER);
		      document.add(endingMSg);		
		      document.add(spaces);
		      document.add(space);
		      document.add(spaces);
		      document.add(programmersNames);
		      document.close();
		      
	    } catch (DocumentException e) {
	      e.printStackTrace();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException ioe) {
	      ioe.printStackTrace();
	    }
			
			return pdfLoc;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;  
	}

	@Override
	public void sendEmail(String pdfLoc) {
		// TODO Auto-generated method stub
		final String username = "bscsmail.se31@gmail.com";
	    final String password = "BSCS-SE31";
	    
	    System.out.println("Email User: " + this.email);
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	    
	    try {

	    	 MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(username));
	         message.setRecipients(Message.RecipientType.TO,
	                 InternetAddress.parse(this.email));
	         message.setSubject("Official Receipt of the Phone Pirate 2021");

	         MimeBodyPart messageBodyGreeting = new MimeBodyPart();
	         messageBodyGreeting.setText("Hi, " + this.user + "\n\t\tThank you for purchasing in phone pirates arrrr...hope to see you again MATEYYY!!!");
	         MimeBodyPart messageBodyGreeting2 = new MimeBodyPart();
	         messageBodyGreeting2.setText("\n________________________________________________________________________________________________________________________________________");
	         
	         MimeBodyPart messageBodyPart = new MimeBodyPart();

	         Multipart multipart = new MimeMultipart();
	         
	         String file = pdfLoc;
	         String fileName = "Resibo"+ new java.util.Date().getTime() + ".pdf";
	         DataSource source = new FileDataSource(file);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(fileName);
	         multipart.addBodyPart(messageBodyGreeting);
	         multipart.addBodyPart(messageBodyGreeting2);
	         multipart.addBodyPart(messageBodyPart);
	         
	         message.setContent(multipart);

	         System.out.println("Sending");

	         Transport.send(message);

	         System.out.println("Done");

	     } catch (MessagingException e) {
	         e.printStackTrace();
	     }
	   }

	@Override
	public void cancelOrder() {
		// TODO Auto-generated method stub
		int count = SingletonDB.getCartRow();
		for(int i = 1; i<=count; i++) {
			if(SingletonDB.getCartData(i) != null) {
				cart cart = SingletonDB.getCartData(i);
				this.quantity = cart.getQuantity();
				this.inventory = SingletonDB.getInventory(cart.getPhoneID());
				int inventoryUpdated = this.inventory + this.quantity;
				SingletonDB.updateQty(cart.getPhoneID(), inventoryUpdated);
				SingletonDB.removeCartItem(i);
			}
		}
	}
}
