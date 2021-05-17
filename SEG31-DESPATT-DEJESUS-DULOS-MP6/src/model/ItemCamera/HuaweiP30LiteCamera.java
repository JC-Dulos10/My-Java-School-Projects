package model.ItemCamera;

import model.phone.Phones;
import utility.SingletonDB;

public class HuaweiP30LiteCamera extends ItemCamera{

	@Override
	public void SetCameraDetails(String input) {
		// TODO Auto-generated method stub
		setDetails(SingletonDB.getCameraDetails(input));
	}

	@Override
	public ItemCamera clone() {
		// TODO Auto-generated method stub
		return new HuaweiP30LiteCamera();
	}

	
}
