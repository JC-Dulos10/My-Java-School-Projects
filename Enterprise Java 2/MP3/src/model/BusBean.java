package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import utility.*;


public class BusBean implements DBOperation{

	//create instance variables
	
	//input values
	private String busName;
	private String plateNumber;
	private String driverAssigned;
	
	//result
	private String endNumber;
	private String dateCoding;
	private boolean isValid = true;
	
	private boolean isDBCreated = false;

	
	public BusBean() {	
	}
	
	public BusBean(String busName, String plateNumber, String driverAssigned) {
		this.busName = busName;
		this.plateNumber = plateNumber.toUpperCase();
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

	public boolean isDBCreated() {
		return isDBCreated;
	}

	public void setDBCreated(boolean isDBCreated) {
		this.isDBCreated = isDBCreated;
	}

	//Getting the last number in the plate number to get the number coding 
	public void findEndNumber() {
		int num = this.plateNumber.length() - 1 ;
		this.endNumber = this.plateNumber.substring(num);
	}
	
	//getting the date based on the ending of the plate number
	public void findDateCoding() {
		findEndNumber();
		
		//checking variables
		System.out.println("End Number: " + this.endNumber);
		System.out.println("isValid: " + this.isValid);
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
	
	
	//JDBC CODES
	
	private Connection getConnectionNoDB() {
		Connection connection = null;
		try {
			connection = ((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/CREATE_DB"))
					.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		return connection;
	}
	
	private Connection getConnection()  {
		Connection connection = null;
		try {
			connection = ((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/BUS_DB"))
						.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		return connection;
	}
	
	public boolean checkDBExist() {
		Connection connection = getConnection();
		boolean isExist = false;
		if(connection != null) {
			isExist = true;
		}
		return isExist;
	}
	
	public void createDB() {
		Connection connection = getConnectionNoDB();
		
		if (connection != null) {
			try {
				PreparedStatement pstmnt = connection.prepareStatement(CREATE_DB);
				pstmnt.executeUpdate();
				pstmnt.close();
				isDBCreated = true;
				createTable();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void createTable() {
		Connection connection = getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement pstmnt = connection.prepareStatement(CREATE_TABLE);
				pstmnt.executeUpdate();
				pstmnt.close();
				alterTablePK();
				alterTableAI();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void alterTablePK() {
		Connection connection = getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement pstmnt = connection.prepareStatement(ALTER_TABLE_PK);
				pstmnt.executeUpdate();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void alterTableAI() {
		Connection connection = getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement pstmnt = connection.prepareStatement(ALTER_TABLE_AI);
				pstmnt.executeUpdate();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean isRecordInserted() {
		boolean isSuccessful = false;
		Connection connection = getConnection();
		
		if (connection != null) {
			try {
				connection.setAutoCommit(false); //start of transaction
				PreparedStatement pstmnt = connection.prepareStatement(INSERT_RECORD);
				pstmnt.setString(1, this.busName);
				pstmnt.setString(2, this.plateNumber);
				pstmnt.setString(3, this.driverAssigned);
				pstmnt.setString(4, this.dateCoding);			
				pstmnt.executeUpdate();
				connection.commit();
				isSuccessful = true;
			} catch (SQLException sqle) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sqle.printStackTrace();
			}
		} 
		return isSuccessful;
	}
	
	public ResultSet getAllRecords() {
		ResultSet records = null;
		Connection connection = getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement pstmnt = connection.prepareStatement(GET_ALL_RECORDS);
				records = pstmnt.executeQuery();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				
			}
		} 
		return records;
	}
}
