package model.charger;

import model.packaging.Packing;
import model.phone.ProductItem;
import model.packaging.ChargerBox;

public abstract class Charger implements ProductItem{

	@Override
	public Packing packing() {
	      return new ChargerBox();
	}
}
