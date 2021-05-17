package model.packaging;

import java.util.ArrayList;
import java.util.List;

import model.phone.*;

public class ItemSet {
	private ArrayList<ProductItem> Items = new ArrayList<ProductItem>();	
	
	public void addItem(ProductItem phone_item){
		Items.add(phone_item);
	   }

	   public Double getCost(){
	      Double cost = 0.0;
	      
	      for (ProductItem phone_item : Items) {
	         cost += phone_item.price();
	      }		
	      return cost;
	   }
	   
	   public ArrayList<String> showItems(){
		   
		   ArrayList<String> message = new ArrayList();
		   
		   System.out.println("inside itemset");
		   
	      for (ProductItem item : Items) {
	    	  
	         System.out.print("Item : " + item.name());
	         System.out.print(", Packing : " + item.packing().box());
	         if(item.price() == 0.0) {
	        	 
	        	 String msg = "Item : " + item.name() +  ", Packing : " + item.packing().box() + ", Price : PHP." + item.price() + "0 Free with the phone";
	        	 
	        	 System.out.println(msg);
	        	 
	        	 message.add(msg);
	         } else {
		         
		         String msg = "Item : " + item.name() +  ", Packing : " + item.packing().box() +  ", Price : PHP." + item.price() + "0";
	        	 
		         System.out.println(msg);
		         
		         message.add(msg);
	         }

	      }	
	      return message;
	   }
	   
	   public ArrayList<String> showItemsJsp(){
		   
		   ArrayList<String> message = new ArrayList();
		   
		   System.out.println("inside itemset");
		   
	      for (ProductItem item : Items) {
	    	  
	         System.out.print("Item : " + item.name());
	         System.out.print(", Packing : " + item.packing().box());
	         if(item.price() == 0.0) {
	        	 
	        	 String msg = "Item : " + item.name() +  "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Packing : " + item.packing().box() + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price : PHP." + item.price() + "0 Free with the phone";
	        	 
	        	 System.out.println(msg);
	        	 
	        	 message.add(msg);
	         } else {
		         
		         String msg = "Item : " + item.name() +  "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Packing : " + item.packing().box() +  "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price : PHP." + item.price() + "0";
	        	 
		         System.out.println(msg);
		         
		         message.add(msg);
	         }

	      }	
	      return message;
	   }
}
