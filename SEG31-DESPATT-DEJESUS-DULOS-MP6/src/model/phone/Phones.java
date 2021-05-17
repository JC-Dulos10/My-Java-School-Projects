package model.phone;

import model.ItemCamera.ItemCamera;
import model.packaging.*;

public abstract class Phones implements ProductItem{
	
	//Variables
	private String Pic;
	private Double Price;
	private String Details;
	private String Name;
	private int id;
	private int inventory;
	
	public abstract Phones clone();
	
	//Getter and Setter
	public void setId(int id) {
		this.id = id;
	}
	public void setPic(String pic) {
		Pic = pic;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return id;
	}
	public String getPic() {
		return Pic;
	}
	public Double getPrice() {
		return Price;
	}
	public String getDetails() {
		return Details;
	}
	public String getName() {
		return Name;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public abstract void setCamera(ItemCamera Camera);
	public abstract ItemCamera getCamera();
	public abstract void setValues(String input);

	@Override
	public Packing packing() {
	      return new PhoneBox();
	}
}
