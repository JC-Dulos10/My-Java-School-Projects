package utility;

import java.util.HashMap;
import java.util.Map;

import model.ItemCamera.HuaweiP30LiteCamera;
import model.ItemCamera.Iphone12ProCamera;
import model.ItemCamera.ItemCamera;
import model.ItemCamera.SamsungGalaxyS20Camera;
import model.phone.*;


public class ItemCameraFactory implements AbstractFactory {
	
private static final Map<String, ItemCamera> prototypes = new HashMap<>();
	
	static {
        System.out.println("inside Factory static");
        prototypes.put("IPHONE 12 PRO", new Iphone12ProCamera());
        prototypes.put("HUAWEI P30 LITE", new HuaweiP30LiteCamera());
        prototypes.put("SAMSUNG GALAXY S20", new SamsungGalaxyS20Camera());
    }
	
	@Override
	public Phones PhoneModel(String PhoneModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemCamera getPhoneCameraDetails(String PhoneModel) {
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
}
	

