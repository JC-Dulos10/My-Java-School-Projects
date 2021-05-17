package utility;

import model.phone.*;
import model.*;
import model.ItemCamera.*;


public interface AbstractFactory {
	Phones PhoneModel(String PhoneModel);
	ItemCamera getPhoneCameraDetails(String PhoneModel);
}

