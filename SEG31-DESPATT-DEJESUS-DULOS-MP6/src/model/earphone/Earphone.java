package model.earphone;

import model.packaging.Packing;
import model.packaging.EarphoneBox;
import model.phone.ProductItem;

public abstract class Earphone implements ProductItem{

	@Override
	public Packing packing() {
	      return new EarphoneBox();
	}
}
