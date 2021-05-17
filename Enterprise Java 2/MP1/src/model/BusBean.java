package model;

public class BusBean {

	//create instance variables
	
	//input values
	private String busName;
	private String plateNumber;
	private String driverAssigned;
	
	//result
	private String endNumber;
	private String dateCoding;
	private boolean isValid = true;
	
	public BusBean() {	
	}
	
	public BusBean(String busName, String plateNumber, String driverAssigned) {
		this.busName = busName;
		this.plateNumber = plateNumber;
		this.driverAssigned = driverAssigned;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber.toUpperCase(); // plate numbers in the Philippines the letters are always in upper case 
	}

	public String getDriverAssigned() {
		return driverAssigned;
	}

	public void setDriverAssigned(String driverAssigned) {
		this.driverAssigned = driverAssigned;
	}

	public String getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(String endNumber) {
		this.endNumber = endNumber;
	}

	public String getDateCoding() {
		return dateCoding;
	}

	public void setDateCoding(String dateCoding) {
		this.dateCoding = dateCoding;
	}
	
	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	//Getting the last number in the plate number to get the number coding 
	public void findEndNumber() {
		int num = this.plateNumber.length() - 1 ;
		this.endNumber = this.plateNumber.substring(num);
	}
	
	//getting the date based on the ending of the plate number
	public void findDateCoding() {
		findEndNumber();
		if((this.endNumber.equals("1")) || (this.endNumber.equals("2"))) {
			this.dateCoding = "Monday";
		} else if((this.endNumber.equals("3")) || (this.endNumber.equals("4"))) {
			this.dateCoding = "Tuesday";
		} else if((this.endNumber.equals("5")) || (this.endNumber.equals("6"))) {
			this.dateCoding = "Wednesday";
		} else if((this.endNumber.equals("7")) || (this.endNumber.equals("8"))) {
			this.dateCoding = "Thursday";
		} else if((this.endNumber.equals("9")) || (this.endNumber.equals("0"))) {
			this.dateCoding = "Friday";
		} else {
			this.isValid = false;
		}
	}

	
}
