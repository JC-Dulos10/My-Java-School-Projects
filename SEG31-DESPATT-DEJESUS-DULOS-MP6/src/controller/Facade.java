package controller;

public interface Facade {

	//Search
	public Boolean searchProdSetProcess();
	
	//Add to Cart
	public void addToCart();
	
	//Remove to Cart
	public void removeToCart();
	
	//Checkout
	public Boolean checkoutItems();
	
	//Cancel Order
	public void cancelOrder();
	
	//luhn algo given code
	public Boolean luhnTest(String number);
	
	//check if ccv is numeric
	public Boolean isNumeric(String strNum);
	
	//check if length
    public Boolean isLengthValid(String num);
    
    //check expiration date
  	public Boolean isExpired();
  	
  	//creating pdf
  	public String createPDF();
  	
  	//sending the Email
  	public void sendEmail(String pdfLoc);
  	
}
