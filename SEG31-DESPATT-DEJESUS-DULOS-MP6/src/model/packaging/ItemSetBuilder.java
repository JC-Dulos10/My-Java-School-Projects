package model.packaging;


import model.ItemCamera.HuaweiP30LiteCamera;
import model.ItemCamera.Iphone12ProCamera;
import model.ItemCamera.ItemCamera;
import model.ItemCamera.SamsungGalaxyS20Camera;
import model.phone.*;
import model.earphone.*;
import model.charger.*;
import utility.ItemCameraFactory;
import utility.PhoneDeviceFactory;

public class ItemSetBuilder {

	public ItemSet IphoneSetBuilder(String phone_name){
		
		ItemSet iphone12Pro_set = new ItemSet();
		
    	Phones phone = new PhoneDeviceFactory().PhoneModel(phone_name);
    	ItemCamera PhoneCamera  = new ItemCameraFactory().getPhoneCameraDetails(phone_name);
		phone.setCamera(PhoneCamera);
		
		Iphone12Pro Iphone12Pro = (Iphone12Pro) phone;
		Iphone12ProCamera Iphone12ProCam = (Iphone12ProCamera) phone.getCamera();
		
		Iphone12Pro.setValues(phone_name);
		Iphone12ProCam.SetCameraDetails(phone_name);
			
		//add item
    	iphone12Pro_set.addItem(Iphone12Pro);
    	iphone12Pro_set.addItem(new Iphone12ProCharger());
    	iphone12Pro_set.addItem(new Iphone12ProEarphone());
    	
	    return iphone12Pro_set;
	}   
	
	public ItemSet S20SetBuilder(String phone_name){
		
		ItemSet S20Galaxy_set = new ItemSet();

    	Phones phone = new PhoneDeviceFactory().PhoneModel(phone_name);
    	ItemCamera PhoneCamera  = new ItemCameraFactory().getPhoneCameraDetails(phone_name);
		phone.setCamera(PhoneCamera);
		
		SamsungGalaxyS20 SamsungGalaxyS20 = (SamsungGalaxyS20) phone;
		SamsungGalaxyS20Camera SamsungGalaxyS20Cam = (SamsungGalaxyS20Camera) phone.getCamera();
		
		SamsungGalaxyS20.setValues(phone_name);
		SamsungGalaxyS20Cam.SetCameraDetails(phone_name);
		
		//add item
		S20Galaxy_set.addItem(SamsungGalaxyS20);
		S20Galaxy_set.addItem(new SamsungGalaxyS20Charger());
		S20Galaxy_set.addItem(new SamsungGalaxyS20Earphone());
	   
	    return S20Galaxy_set;
	}
	
	public ItemSet P30SetBuilder(String phone_name){
	    
	    ItemSet P30LiteHuawei_set = new ItemSet();
	    	
    	Phones phone = new PhoneDeviceFactory().PhoneModel(phone_name);
    	ItemCamera PhoneCamera  = new ItemCameraFactory().getPhoneCameraDetails(phone_name);
		phone.setCamera(PhoneCamera);
		
		HuaweiP30Lite HuaweiP30Lite = (HuaweiP30Lite) phone;
		HuaweiP30LiteCamera HuaweiP30LiteCam = (HuaweiP30LiteCamera) phone.getCamera();
		
		HuaweiP30Lite.setValues(phone_name);
		HuaweiP30LiteCam.SetCameraDetails(phone_name);
		
		//add item
		P30LiteHuawei_set.addItem(HuaweiP30Lite);
		P30LiteHuawei_set.addItem(new HuaweiP30LiteCharger());
		P30LiteHuawei_set.addItem(new HuaweiP30LiteEarphone());
			
	    return P30LiteHuawei_set;
	}
}
