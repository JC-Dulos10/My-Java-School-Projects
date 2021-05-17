package model.ItemCamera;

import utility.SingletonDB;

public class SamsungGalaxyS20Camera extends ItemCamera{

	@Override
	public void SetCameraDetails(String input) {
		// TODO Auto-generated method stub
		setDetails(SingletonDB.getCameraDetails(input));
	}

	@Override
	public ItemCamera clone() {
		// TODO Auto-generated method stub
		return new SamsungGalaxyS20Camera();
	}

	
}
