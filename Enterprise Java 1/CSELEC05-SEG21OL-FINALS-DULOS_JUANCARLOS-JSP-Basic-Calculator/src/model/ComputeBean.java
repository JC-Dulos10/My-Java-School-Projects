package model;

public class ComputeBean {

	//create instance variables
	//input values
	private String operator;
	private double value1;
	private double value2;
	private String errMsg = "";
	
	//computed or derived values
	private double value3 = 0;
	
	public ComputeBean() {	
	}

	public ComputeBean(String operator, double value1, double value2) {
		this.operator = operator;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getValue1() {
		return value1;
	}

	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double value2) {
		this.value2 = value2;
	}

	public double getValue3() {
		return value3;
	}

	public void setValue3(double value3) {
		this.value3 = value3;
	}

	public void computeValue() {
		if(this.getValue2() == 0) {
			errMsg = "You are dividing by zero...Try again...Division by zero cannot be done...";
			this.setErrMsg(errMsg);
		} else {
			if (operator.equals("add")) {
				this.value3 = this.value1 + this.value2;
			} else if (operator.equals("subtract")) {
				this.value3 = this.value1 - this.value2;
			} else if (operator.equals("multiply")) {
				this.value3 = this.value1 * this.value2;
			} else if (operator.equals("divide")) {
				this.value3 = this.value1 / this.value2;
			} 
		}
	}
}
