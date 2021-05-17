package model.phone;

import java.util.ArrayList;
import java.util.Iterator;

import model.ItemCamera.ItemCamera;
import utility.SingletonDB;

public class HuaweiP30Lite extends Phones{

	private ItemCamera camera;
	
	@Override
	public void setCamera(ItemCamera Camera) {
		// TODO Auto-generated method stub
		this.camera = Camera;
	}

	@Override
	public ItemCamera getCamera() {
		// TODO Auto-generated method stub
		return this.camera;
	}

	@Override
	public void setValues(String input) {
		// TODO Auto-generated method stub
		ArrayList<String> data = SingletonDB.getData(input);
		Iterator<String> itr = data.iterator();
	    while(itr.hasNext()) {
	    	setId(Integer.parseInt(itr.next()));
	    	setName(itr.next());
	    	setPic(itr.next());
			setPrice(Double.parseDouble(itr.next()));
			setDetails(itr.next());
			setInventory(Integer.parseInt(itr.next()));
			
			System.out.println("using Iterator...");
			System.out.println("Name: " + getName());
			System.out.println("Pic: " + getPic());
			System.out.println("Details: " + getDetails());
			System.out.println("Price: " + getPrice());
			System.out.println("Inventory: " + getInventory());
	    }
	}

	@Override
	public Phones clone() {
		// TODO Auto-generated method stub
		return new HuaweiP30Lite();
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return getName();
	}

	@Override
	public Double price() {
		// TODO Auto-generated method stub
		return getPrice();
	}

	@Override
	public String pic() {
		// TODO Auto-generated method stub
		return getPic();
	}



}
