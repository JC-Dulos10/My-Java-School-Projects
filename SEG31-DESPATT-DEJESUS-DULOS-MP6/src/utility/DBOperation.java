package utility;

public interface DBOperation {
	
	//phone db
	String CREATE_PHONETABLE = "CREATE TABLE IF NOT EXISTS `phones` (\r\n"
			+ "  `id` int(11) NOT NULL,\r\n"
			+ "  `Name` varchar(150) NOT NULL,\r\n"
			+ "  `Pic` varchar(250) NOT NULL,\r\n"
			+ "  `Price` int(11) NOT NULL,\r\n"
			+ "  `Details` varchar(500) NOT NULL,\r\n"
			+ "  `camID` int(11) NOT NULL,\r\n"
			+ "  `Inventory` int(11) NOT NULL"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	
	String ALTER_PHONETABLE_PK = "ALTER TABLE `phones`\r\n" + 
			"  ADD PRIMARY KEY (`id`);";
	
	String ALTER_PHONETABLE_AI = "ALTER TABLE `phones`\r\n" + 
			"  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
	
	//cam table
	String CREATE_CAMTABLE = "CREATE TABLE IF NOT EXISTS `cam` (\r\n"
			+ "  `id` int(11) NOT NULL,\r\n"
			+ "  `Name` varchar(150) NOT NULL,\r\n"
			+ "  `Details` varchar(500) NOT NULL\r\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	
	String ALTER_CAMTABLE_PK = "ALTER TABLE `cam`\r\n" + 
			"  ADD PRIMARY KEY (`id`);";
	
	String ALTER_CAMTABLE_AI = "ALTER TABLE `cam`\r\n" + 
			"  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
	
	//cart table
	String CREATE_CARTTABLE = "CREATE TABLE `cart` (\r\n"
			+ "  `id` int(11) NOT NULL,\r\n"
			+ "  `phoneID` int(11) NOT NULL,\r\n"
			+ "  `quantity` int(11) NOT NULL,\r\n"
			+ "  `price` Double NOT NULL,\r\n"
			+ "  `totalPrice` Double NOT NULL,\r\n"
			+ "  `orderNo` int(11) NOT NULL\r\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	
	String ALTER_CARTTABLE_PK = "ALTER TABLE `cart`\r\n"
			+ "  ADD PRIMARY KEY (`id`);";
		
	
	String ALTER_CARTTABLE_AI = "ALTER TABLE `cart`\r\n"
			+ "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;";
	
	//order cart table
	String CREATE_ORDERCARTTABLE = "CREATE TABLE `orderCart` (\r\n"
			+ "  `id` int(11) NOT NULL,\r\n"
			+ "  `phoneID` int(11) NOT NULL,\r\n"
			+ "  `quantity` int(11) NOT NULL,\r\n"
			+ "  `price` Double NOT NULL,\r\n"
			+ "  `totalPrice` Double NOT NULL,\r\n"
			+ "  `orderNo` int(11) NOT NULL\r\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	
	String ALTER_ORDERCARTTABLE_PK = "ALTER TABLE `orderCart`\r\n"
			+ "  ADD PRIMARY KEY (`id`);";
		
	
	String ALTER_ORDERCARTTABLE_AI = "ALTER TABLE `orderCart`\r\n"
			+ "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;";
	
	//Order table
	String CREATE_ORDERTABLE = "CREATE TABLE `order` (\r\n"
			+ "  `id` int(11) NOT NULL,\r\n"
			+ "  `customerName` varchar(500) NOT NULL,\r\n"
			+ "  `email` varchar(500) NOT NULL,\r\n"
			+ "  `address` varchar(500) NOT NULL,\r\n"
			+ "  `status` varchar(500) NOT NULL\r\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
	
	String ALTER_ORDERTABLE_PK = "ALTER TABLE `order`\r\n"
			+ "  ADD PRIMARY KEY (`id`);";
		
	
	String ALTER_ORDERTABLE_AI = "ALTER TABLE `order`\r\n"
			+ "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;";
	
	//INSERT DB DATA
	String INSERT_PHONE_RECORD = "INSERT INTO `phones` (`id`, `Name`, `Pic`, `Price`, `Details`, `camID`, `Inventory`) VALUES\r\n"
			+ "(1, 'IPHONE 12 PRO', 'images/Phones/iphone12.png', 62990, 'he Apple iPhone 12 Pro Max looks stunning with its new shiny steel frame design, an improved DSLR-like camera, 5nm A14 chipset and its new features such as IP68 water resistance, MagSafe wireless charging, and Super Retina XDR display.', 3, 10),\r\n"
			+ "(2, 'SAMSUNG GALAXY S20', 'images/Phones/s20.png', 41880, 'The Samung Galaxy S20 is an IP68-certified waterproof smartphone which comes in a 6.2-inch punch-hole display housing a 10MP front camera with fast AF capture and a rear camera equipped with AI stabilizer feature.', 2, 10),\r\n"
			+ "(3, 'HUAWEI P30 LITE', 'images/Phones/p30.png', 11990, 'The HUAWEI P30 lite is the global version of the nova 4e featuring a Kirin 710 chipset, 4/6GB of RAM, a triple-camera setup at the back, a 32MP front-facing camera, and a 3,340mAh battery.', 1, 10);";

	String INSERT_CAM_RECORD = "INSERT INTO `cam` (`id`, `Name`, `Details`) VALUES\r\n"
			+ "(1, 'HuaweiP30LiteCamera', 'The Huawei P30 Lite has a triple camera on its back - the main 48MP PDAF f/1.8 snapper is joined by an 8MP fixed-focus, f/2.4 ultra-wide, and a 2MP, fixed-focus, \\\"f/2.4 depth sensor. There is also a single LED flash around.'),\r\n"
			+ "(2, 'SamsungGalaxyS20Camera', 'The most powerful selfie camera on a Galaxy phone yet. Galaxy S20 Ultra 40 megapixel front camera gives you pro-grade tech so selfies come out detailed — and shifts to 10MP with larger pixels for crisp low light selfies.'),\r\n"
			+ "(3, 'Iphone12ProCamera', 'The iPhone 12 Pro has a 2x optical zoom in, 2x optical zoom out, 4x optical zoom range, and digital zoom up to 10x while the iPhone 12 Pro Max has a 2.5x optical zoom in, 2x optical zoom out, 5x optical zoom range, and digital zoom up to 12x.');";

	//JDBC
	String SELECT_PHONE = "SELECT `id`, `Name`, `Pic`, `Price`, `Details`, `camID`, `Inventory` FROM `phones` WHERE Name = ?";
	
	String SELECT_CAM = "SELECT `Name`, `Details` FROM `cam` WHERE id = ?";
	
	String DISPLAY_PHONE = "SELECT `Name`, `Pic`, `Details` FROM `phones` WHERE id = ?";
	
	String UPDATE_QUANTITY = "UPDATE `phones` SET `Inventory`= ? WHERE id = ?";
	
	String GET_PHONE_ID_LASTDATA = "SELECT * FROM phones WHERE id=(SELECT max(id) FROM phones)";
	
	String SEARCH_PHONE = "SELECT `Name`, `Pic` FROM `phones` where Name LIKE ?";
	
	//CART
	String ADD_CART = "INSERT INTO `cart`( `phoneID`, `quantity`, `price`, `totalPrice`, orderNo) VALUES (?,?,?,?,?);";
	
	String SELECT_CART = "SELECT `id`, `phoneID`, `quantity`, `price`, `totalPrice`, `orderNo` FROM `cart` WHERE id = ?";
	
	String UPDATE_TOTAL_PRICE = "UPDATE `cart` SET `totalPrice`= ? WHERE id = ?";
	
	String GET_LAST_ITEM_ID = "SELECT * FROM cart WHERE id=(SELECT max(id) FROM cart)";
	
	String SELECT_PHONENAME = "SELECT `Name` FROM `phones` WHERE id = ?";
	
	String SELECT_PHONEPIC = "SELECT `Pic` FROM `phones` WHERE id = ?";
	
	String REMOVE_CART_ITEM = "DELETE FROM `cart` WHERE id = ?";
	
	String UPDATE_CART_QUANTITY = "UPDATE `cart` SET `quantity`=? WHERE phoneID = ?";
	
	String GET_ROW_COUNT = "select count(*) from cart";
	
	String UPDATE_ORDERNUM = "UPDATE `cart` SET `orderNo`=? WHERE id = ?";
	
	//Order 
	String INSERT_ORDER = "INSERT INTO `order`(`customerName`, `email`, `address`, `status`) VALUES (?,?,?,?);";
	
	String ADD_ORDERCART = "INSERT INTO `orderCart`( `phoneID`, `quantity`, `price`, `totalPrice`, `orderNo`) VALUES (?,?,?,?,?);";
	
	String REMOVE_ORDERCART_ITEM = "DELETE FROM `orderCart` WHERE id = ?;";
	
}
