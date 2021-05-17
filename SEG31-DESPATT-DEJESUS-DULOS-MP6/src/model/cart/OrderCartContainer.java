package model.cart;

import utility.SingletonDB;

public class OrderCartContainer {

	private int id; 
	private int phoneID;
	private int quantity;
	private Double price;
	private Double totalPrice;
	private int orderNo;
	
	public OrderCartContainer(int id, int phoneID, int quantity, Double price, Double totalPrice, int orderNum) {
		this.id =id;
		this.phoneID = phoneID;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.orderNo = orderNum;
	}

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

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	
}
