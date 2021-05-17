package model.cart;

import java.util.ArrayList;
import java.util.Iterator;
import utility.SingletonDB;

public class OrderCartRepository implements OrderIterator{

	ArrayList<OrderCartContainer> orders;
	
	public OrderCartRepository() {
		orders = new ArrayList<OrderCartContainer>();
		int count = SingletonDB.getCartRow();
		for(int i = 0; i<= count; i++) {
			if(SingletonDB.getCartData(i) != null){
				cart cartUser = SingletonDB.getCartData(i);
				addOrder(cartUser.getId(), cartUser.getPhoneID(), cartUser.getQuantity(), cartUser.getPrice(), cartUser.getTotalPrice(), cartUser.getOrderNum());
			}
		}
				
	}
	
	public void addOrder(int id, int phoneID, int quantity, Double price, Double totalPrice, int orderNo) {
		OrderCartContainer orderCartInfo = new OrderCartContainer(id, phoneID, quantity, price, totalPrice, orderNo);
		orders.add(orderCartInfo);
	}
	
	
	
	public ArrayList<OrderCartContainer> getOrders(){
		return orders;
	}
	
	@Override
	public Iterator createIterator() {
		return orders.iterator();
	}

	
}
