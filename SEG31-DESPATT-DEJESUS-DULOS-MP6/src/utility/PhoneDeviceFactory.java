package utility;

import model.ItemCamera.ItemCamera;
import model.phone.*;
import java.util.HashMap;
import java.util.Map;


public class PhoneDeviceFactory implements AbstractFactory {
	
	private static final Map<String, Phones> prototypes = new HashMap<>();
	
	static {
        System.out.println("inside Factory static");
        prototypes.put("IPHONE 12 PRO", new Iphone12Pro());
        prototypes.put("HUAWEI P30 LITE", new HuaweiP30Lite());
        prototypes.put("SAMSUNG GALAXY S20", new SamsungGalaxyS20());
    }
	
	@Override
	public Phones PhoneModel(String PhoneModel) {
		// TODO Auto-generated method stub
		System.out.println("INSIDE PROTOTYPE");
        try {
        	//return cloned object to fight for the Grand Army of the republic
            return prototypes.get(PhoneModel).clone();
        } catch(NullPointerException ex){
        	//check if does not exist
            System.out.println("Prototype with name: " + PhoneModel + ", doesn't exist");
            return null;
        }
	}

	@Override
	public ItemCamera getPhoneCameraDetails(String PhoneModel) {
		// TODO Auto-generated method stub
		return null;
	}

}

