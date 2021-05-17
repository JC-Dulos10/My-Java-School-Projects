package model;

import javax.servlet.ServletContext;

public class EmployeeBean {
	
	
	private String id;
	private String name;
	private String code;
	private double saleAmount;
	private double takeHomePay;
	private double grossEarned;
	private double saleCommission;
	private ServletContext application;
	
	public EmployeeBean() {
		
	}

	public EmployeeBean(String id, String name, String code, double saleAmount, ServletContext application) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.saleAmount = saleAmount;
		this.application = application;
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
	
	//Double.parseDouble(application.getInitParameter("salesCodeAPercentage"))
	public void computeTakeHomePay() {
		if(this.code.equals(application.getInitParameter("salesCodeA"))) {
			this.grossEarned = this.saleAmount * Double.parseDouble(application.getInitParameter("salesCodeAPercentage")) 
					+ Double.parseDouble(application.getInitParameter("salesCodeABonus"));
		} else if(this.code.equals(application.getInitParameter("salesCodeB"))) {
			this.grossEarned = this.saleAmount * Double.parseDouble(application.getInitParameter("salesCodeBPercentage")) 
					+ Double.parseDouble(application.getInitParameter("salesCodeBBonus"));
		}
		if(this.saleAmount > Double.parseDouble(application.getInitParameter("amountGreaterThan"))) {
			this.saleCommission = saleAmount * Double.parseDouble(application.getInitParameter("additionalSales"));
		} else {
			this.saleCommission = Double.parseDouble(application.getInitParameter("zero"));
		}
		this.takeHomePay = this.grossEarned + this.saleCommission;
	}
	
}
