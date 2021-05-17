package utility;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.source.tree.WhileLoopTree;

import javassist.compiler.ast.Stmnt;
import model.*;
import model.ItemCamera.ItemCamera;
import model.phone.DisplayItem;
import model.phone.HuaweiP30Lite;
import model.phone.Iphone12Pro;
import model.phone.Phones;
import model.phone.SamsungGalaxyS20;
import model.cart.cart;

public class SingletonDB implements DBOperation{

	//this is defaulted to null
		private static Connection connection; 
		private static PreparedStatement pstmnt = null;
		
		private SingletonDB() {
			
		}
		
		//DB connection if db exist
		private static Connection getDBConnection() {
			connection = null;
			try {
				connection = ((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/MAIN_DB")).getConnection();
			} catch (SQLException sqle) {
				System.err.println(sqle.getMessage());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return connection;
		}
		
		//now this is the global method that can be accessed statically by
		//other classes when creating a Connection object
		public static Connection getConnection() {
			return (( connection !=null )
				? connection
				: getDBConnection());		
		}
		
		//Create phone table
		public static void createPhoneTable() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(CREATE_PHONETABLE);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterPhoneTablePK() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_PHONETABLE_PK);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterPhoneTableAI() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_PHONETABLE_AI);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//Create Cam Table
		public static void createCamTable() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(CREATE_CAMTABLE);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterCamTablePK() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_CAMTABLE_PK);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterCamTableAI() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_CAMTABLE_AI);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//create cart table
		public static void createCartTable() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(CREATE_CARTTABLE);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterCartTablePK() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_CARTTABLE_PK);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterCartTableAI() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_CARTTABLE_AI);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//create Order cart table
		public static void createOrderCartTable() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(CREATE_ORDERCARTTABLE);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterOrderCartTablePK() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_ORDERCARTTABLE_PK);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterOrderCartTableAI() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_ORDERCARTTABLE_AI);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//create Order table
		public static void createOrderTable() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(CREATE_ORDERTABLE);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterOrderTablePK() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_ORDERTABLE_PK);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public static void alterOrderTableAI() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(ALTER_ORDERTABLE_AI);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
				
		//check if table exists
		public static Boolean checkIfPhoneTableExist() {
			boolean isExist = false;
			connection = getConnection(); 
			DatabaseMetaData dbm;
			try {
				dbm = connection.getMetaData();
				// check if "employee" table is there
				ResultSet tables = dbm.getTables(null, null, "phones", null);
				if (tables.next()) {
				  // Table exists
				  System.out.println("PHONE TABLE EXISTS");
				  isExist = true;
				} else {
				  // Table does not exist
				  System.out.println("PHONE TABLE DOES NOT EXISTS");
				  
				  //phone
				  createPhoneTable();
				  alterPhoneTablePK();
				  alterPhoneTableAI();
				  insertPhoneData();
				  
				  //cam
				  createCamTable();
				  alterCamTablePK();
				  alterCamTableAI();
				  insertCamData();
				  
				  //cart
				  createCartTable();
				  alterCartTablePK();
				  alterCartTableAI();
				  
				  //order
				  createOrderTable();
				  alterOrderTablePK();
				  alterOrderTableAI();
				  
				  //order cart
				  createOrderCartTable();
				  alterOrderCartTablePK();
				  alterOrderCartTableAI();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isExist;
		}
				
		public static Boolean checkIfDBExist() {
			Boolean isExist = false;
			connection = getConnection();
			if(connection != null) {
				isExist = true;
			}
			return isExist;
		}
		
		//Inserting Default data;
		//Phone Records
		public static void insertPhoneData() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(INSERT_PHONE_RECORD);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		//Cam Records
		public static void insertCamData() {
			connection = getDBConnection();
			
			if (connection != null) {
				try {
					pstmnt = connection.prepareStatement(INSERT_CAM_RECORD);
					pstmnt.executeUpdate();
					pstmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//Getting Phone details in the DB
		//Getting phone details
		public static ArrayList<String> getData(String input){
			connection = getConnection();
			ArrayList<String> data = new ArrayList<String>();
			
			try {
				//connecting to db
				pstmnt = connection.prepareStatement(SELECT_PHONE);
				pstmnt.setString(1, input);
				
			    ResultSet rs = pstmnt.executeQuery();
			    
			    while(rs.next()){
			         //Retrieve by column name
			    	data.add(rs.getString("id"));
			    	data.add(rs.getString("Name"));
			    	data.add(rs.getString("Pic"));
			    	data.add(rs.getString("Price"));
			    	data.add(rs.getString("Details"));
			    	data.add(rs.getString("Inventory"));
			      }
			      rs.close();
			      pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return data;   
	}
			
		//Getting the Camera details
		public static String getCameraDetails(String input){
		connection = getConnection();
		String Details = "";
		int id =0;
		
		try {
			//connecting to db
			pstmnt = connection.prepareStatement(SELECT_PHONE);
			pstmnt.setString(1, input);
			
		    ResultSet rs = pstmnt.executeQuery();
		    
		    while(rs.next()){
		         //Retrieve by column name
		        id = rs.getInt("camID");
		        System.out.println("CAMERA ID: " + id);
		      }
		      rs.close();
		      pstmnt.close();
		      System.out.println("GETTING CAMERA DETAILS...");
		 	  pstmnt = connection.prepareStatement(SELECT_CAM);
			  pstmnt.setInt(1, id);
				
			  ResultSet rs2 = pstmnt.executeQuery();
			    
			  while(rs2.next()){
			       //Retrieve by column name
			       Details = rs2.getString("Details");
			       System.out.println("CAMERA DETAILS: "+ Details);
			  }
			  rs2.close();
			  pstmnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Details;
	}
	
		//Display phone
		public static DisplayItem getDisplayPhone(int id){
			connection = getConnection();
			DisplayItem display  = new DisplayItem();
	
			try {
				//connecting to dc
				pstmnt = connection.prepareStatement(DISPLAY_PHONE);
				pstmnt.setInt(1, id);
			    ResultSet rs = pstmnt.executeQuery();
			    
			    while(rs.next()){
			         //Retrieve by column name
			        display.setName(rs.getString("Name"));
			        display.setPic(rs.getString("Pic"));
			        display.setDetails(rs.getString("Details"));
			      }
			      rs.close();
			      pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return display;
		}
		
		//add cart
		public static int addToCart(int phoneID, int qty, Double price, Double totalPrice, int orderNum) {
			int cart_id =0;
			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(ADD_CART, pstmnt.RETURN_GENERATED_KEYS);
				pstmnt.setInt(1, phoneID);
				pstmnt.setInt(2, qty);
				pstmnt.setDouble(3, price);
				pstmnt.setDouble(4, totalPrice);
				pstmnt.setInt(5, orderNum);
				pstmnt.executeUpdate();
				ResultSet rs = pstmnt.getGeneratedKeys();
				while(rs.next()) {
					cart_id = rs.getInt(1);
				}
				
				System.out.println("PHONE ADDED TO CART...");
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cart_id;
			
		}
		
		//Subtract Quantity
		public static void updateQty(int phoneID, int qty) {
			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(UPDATE_QUANTITY);
				pstmnt.setInt(1, qty);
				pstmnt.setInt(2, phoneID);
				pstmnt.executeUpdate();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//Select cart
		public static Double getPrice(int id) {
			connection = getConnection();
			Double price = (double) 0;
			try {
				pstmnt = connection.prepareStatement(SELECT_CART);
				pstmnt.setInt(1, id);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
			      //Retrieve by column name
			      price = rs.getDouble("price");
			    }
			    rs.close();
			    pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return price;
		}
		
		//Update total price
		public static void updateTotalPrice(Double totalPrice, int id) {
			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(UPDATE_TOTAL_PRICE);
				pstmnt.setDouble(1, totalPrice);
				pstmnt.setInt(2, id);
				pstmnt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//getting number of rows in the cart
		public static int getCartRow() {
			connection = getConnection();
			int row = 0;
			try {
				pstmnt = connection.prepareStatement(GET_LAST_ITEM_ID);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
			      //Retrieve by column name
			      row = rs.getInt("id");
			    }
			    rs.close();
			    pstmnt.close();
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row;
		}
		
		//getting number of rows in the phone
		public static int getPhoneRow() {
			connection = getConnection();
			int row = 0;
			try {
				pstmnt = connection.prepareStatement(GET_PHONE_ID_LASTDATA);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
			      //Retrieve by column name
			      row = rs.getInt("id");
			    }
			    rs.close();
			    pstmnt.close();
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row;
		}
		
		//get total Price
		public static Double getTotalPrice() {
			connection = getConnection();
			Double totalPrice = (double) 0;
			try {
				pstmnt = connection.prepareStatement(SELECT_CART);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
			      //Retrieve by column name
				totalPrice = rs.getDouble("totalPrice");
			    }
			    rs.close();
			    pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				totalPrice = (double) 0;
			} 
			return totalPrice;
		}
		
		//get Cart data
		public static cart getCartData(int id) {
			cart cart = new cart();
			connection = getConnection();
			try {
				pstmnt =connection.prepareStatement(SELECT_CART);
				pstmnt.setInt(1, id);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
					cart.setId(rs.getInt("id"));
					cart.setPhoneID(rs.getInt("phoneID"));
					cart.setQuantity(rs.getInt("quantity"));
					cart.setPrice(rs.getDouble("price"));
					cart.setTotalPrice(rs.getDouble("totalPrice"));
					cart.setOrderNum(rs.getInt("orderNo"));
				}
				
				rs.close();
				pstmnt.close();
				if(cart.getId() == 0) {
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return cart;
		}
		
		//get Cart data
		public static int getQuantity(int id) {
			int qty = 0;
			connection = getConnection();
			try {
				pstmnt =connection.prepareStatement(SELECT_CART);
				pstmnt.setInt(1, id);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
					qty = rs.getInt("quantity");
				}
	
				rs.close();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return qty;
		}
		
		//get Phone Name
		public static String getPhoneName(int id) {
			String name = "";
			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(SELECT_PHONENAME);
				pstmnt.setInt(1, id);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
					name = rs.getString("Name");
				}
				rs.close();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return name;
		}
		
		//get Phone Name
		public static String getPhonePic(int id) {
			String pic = "";
			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(SELECT_PHONEPIC);
				pstmnt.setInt(1, id);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
					pic = rs.getString("Pic");
				}
				rs.close();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return pic;
		}


		//remove cart item
		public static void removeCartItem(int id) {
			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(REMOVE_CART_ITEM);
				pstmnt.setInt(1, id);
				pstmnt.executeUpdate();
				pstmnt.close();
				System.out.println("Cart Item: "+id+"has been removed successfully...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//update Cart phone qunatity 
		public static void updateCartPhoneQuantity(int phone_id, int qty) {
			connection = getConnection();
			try {
				pstmnt =connection.prepareStatement(UPDATE_CART_QUANTITY);
				pstmnt.setInt(1, qty);
				pstmnt.setInt(2, phone_id);
				pstmnt.executeUpdate();
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Getting phone details
		public static int getInventory(int phoneID){
			String phoneName = getPhoneName(phoneID);
			connection = getConnection();
			int inventory = 0;
			try {
				//connecting to dc
				pstmnt = connection.prepareStatement(SELECT_PHONE);
				pstmnt.setString(1, phoneName);
			    ResultSet rs = pstmnt.executeQuery();
			    while(rs.next()){
			         //Retrieve by column name
			    	inventory = rs.getInt("Inventory");
			      }
			      rs.close();
			      pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return inventory; 
	}
		
		//getting number of rows in the cart
		public static int getCartRowNum() {
			connection = getConnection();
			int row = 0;
			try {
				pstmnt = connection.prepareStatement(GET_ROW_COUNT);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()){
			      //Retrieve by column name
			      row = rs.getInt(1);
			    }
			    rs.close();
			    pstmnt.close();
			    System.out.println("Cart Row Singleton: "+row);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row;
		}
		
		//OrderNo. add and get Order numberID

		public static int insertOrder(String customerName, String email, String address, String status) {
			connection = getConnection();
			int order_id = 0;
			try {
				pstmnt = connection.prepareStatement(INSERT_ORDER, pstmnt.RETURN_GENERATED_KEYS);
				pstmnt.setString(1, Security.encrypt(customerName));
				pstmnt.setString(2, Security.encrypt(email));
				pstmnt.setString(3, Security.encrypt(address));
				pstmnt.setString(4, Security.encrypt(status));
				pstmnt.executeUpdate();
				ResultSet rs = pstmnt.getGeneratedKeys();
				while(rs.next()) {
					order_id = rs.getInt(1);
				}
				
			    pstmnt.close();
			    System.out.println("Order ID Singleton: "+order_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return order_id;
		}
		
		//add ordercart
		public static void addToOrderCart(int phoneID, int qty, Double price, Double totalPrice, int orderNum) {

			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(ADD_ORDERCART);
				pstmnt.setInt(1, phoneID);
				pstmnt.setInt(2, qty);
				pstmnt.setDouble(3, price);
				pstmnt.setDouble(4, totalPrice);
				pstmnt.setInt(5, orderNum);
				pstmnt.executeUpdate();
				System.out.println("PHONE ADDED TO CART...");
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//Update OrderNum
		public static void updateOrderNumCart(int orderNum, int id) {

			connection = getConnection();
			try {
				pstmnt = connection.prepareStatement(UPDATE_ORDERNUM);
				pstmnt.setInt(1, orderNum);
				pstmnt.setInt(2, id);
				pstmnt.executeUpdate();
				System.out.println("PHONE ADDED TO CART...");
				pstmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		//check if name exist in the db
		public static Boolean checkPhoneExist(String name) {
			Boolean isExist = false;
			try {
				//connecting to db
				String dbName = "";
				connection = getConnection();
				pstmnt = connection.prepareStatement(SELECT_PHONE);
				pstmnt.setString(1, name);
			    ResultSet rs = pstmnt.executeQuery();
			    while(rs.next()){
			    	//Retrieve by column name
			    	dbName = rs.getString("Name");
		       }
		       rs.close();
		       pstmnt.close();
		       
		       //check if phone exist in the db
		       if(dbName.equalsIgnoreCase(name)) {
		    	   isExist = true;
		       }
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return isExist;
		}

		//search phone
		public static ArrayList<DisplayItem> getSearchData(String searchInput) {
			ArrayList<DisplayItem> item = new ArrayList<DisplayItem>();
			try {
				//connecting to db
				searchInput = "%"+searchInput+"%";
				connection = getConnection();
				pstmnt = connection.prepareStatement(SEARCH_PHONE);
				pstmnt.setString(1, searchInput);
			    ResultSet rs = pstmnt.executeQuery();
			    while(rs.next()){
			    	DisplayItem dbItem = new DisplayItem();
			    	dbItem.setName(rs.getString("Name"));
			    	dbItem.setPic(rs.getString("Pic"));
			    	item.add(dbItem);
			    }
		        rs.close();
		        pstmnt.close();
		        Iterator<DisplayItem> itr = item.iterator();
		        while(itr.hasNext()) {
		        	System.out.println("Arraylist inside Name: " + itr.next().getName());
		        	System.out.println("Arraylist inside Pic: " + itr.next().getPic());
		        }
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("\n\n NO PHONES FOUND RESULT SET IS NULL \n\n");
				item = null;
			}
			return item;
		}

		
}
