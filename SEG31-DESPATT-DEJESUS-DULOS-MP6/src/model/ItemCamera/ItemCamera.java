package model.ItemCamera;

import model.phone.Phones;

public abstract class ItemCamera {
	
	//Variables
	private String CameraDetails;
	
	public abstract ItemCamera clone();
	
	//Getter and Setter
	public void setDetails(String CameraDetails) {
		this.CameraDetails = CameraDetails;
	}
	public String getDetails() {
		return CameraDetails;
	}
	
	public abstract void SetCameraDetails(String input);
}
