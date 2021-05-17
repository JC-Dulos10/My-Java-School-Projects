package model.cart;

public class cart {
	
	//Varaibles for the class
	private int id;
	private int phoneID;
	private int quantity;
	private Double price;
	private Double totalPrice;
	private int orderNum;
	
	//Getter and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhoneID() {
		return phoneID;
	}
	public void setPhoneID(int phoneID) {
		this.phoneID = phoneID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
}
