package model;

public class EmployeeBean {
	
	
	private String id;
	private String name;
	private String code;
	private double saleAmount;
	private double takeHomePay;
	private double grossEarned;
	private double saleCommission;
	
	public EmployeeBean() {
		
	}

	public EmployeeBean(String id, String name, String code, double saleAmount) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.saleAmount = saleAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public double getTakeHomePay() {
		return takeHomePay;
	}

	public void setTakeHomePay(double takeHomePay) {
		this.takeHomePay = takeHomePay;
	}

	public double getGrossEarned() {
		return grossEarned;
	}

	public void setGrossEarned(double grossEarned) {
		this.grossEarned = grossEarned;
	}

	public double getSaleCommission() {
		return saleCommission;
	}

	public void setSaleCommission(double saleCommission) {
		this.saleCommission = saleCommission;
	}
	
	public void computeTakeHomePay() {
		if(this.code.equals("A")) {
			this.grossEarned = this.saleAmount*0.50 + 175;
		} else if(this.code.equals("B")) {
			this.grossEarned = this.saleAmount*0.20 + 100;
		}
		if(this.saleAmount > 2500) {
			this.saleCommission = saleAmount * 0.05;
		} else {
			this.saleCommission = 0;
		}
		this.takeHomePay = this.grossEarned + this.saleCommission;
	}
	
}
