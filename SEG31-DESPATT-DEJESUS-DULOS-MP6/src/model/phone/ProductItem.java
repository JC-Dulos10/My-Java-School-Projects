package model.phone;

import model.packaging.*;

public interface ProductItem {
	public String name();
	public Packing packing();
	public Double price();	
	public String pic();
}

