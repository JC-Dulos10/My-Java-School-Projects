package utility;

public interface DBOperation {
	
	String GET_ALL_RECORDS = "select * from vehiclecoding";
	String CREATE_DB = "CREATE DATABASE IF NOT EXISTS `seg31-cselec09_db`";
	String CREATE_TABLE = "CREATE TABLE `vehiclecoding` (\r\n" + 
			"  `id` int(11) NOT NULL,\r\n" + 
			"  `busName` varchar(150) NOT NULL,\r\n" + 
			"  `plateNumber` varchar(10) NOT NULL,\r\n" + 
			"  `driver` varchar(150) NOT NULL,\r\n" + 
			"  `codingDayAssigned` varchar(15) NOT NULL\r\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\r\n";
	
	String ALTER_TABLE_PK = "ALTER TABLE `vehiclecoding`\r\n" + 
			"  ADD PRIMARY KEY (`id`);";
	String ALTER_TABLE_AI = "ALTER TABLE `vehiclecoding`\r\n" + 
			"  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
	String INSERT_RECORD = "INSERT INTO `vehiclecoding`(`busName`, `plateNumber`, `driver`, `codingDayAssigned`) "
			+ "VALUES (?,?,?,?)";
	
}
