package com.jdbc.operationV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperation {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//step 1)Load the driver
	
	//step 2)Establish a connection between Jdbc program and Database
	Connection connection = JdbcUtils.getMysqlConnection();
	//step 3)Prepare the SQL statement
		String query="update student set stu_name='Twinkle Thakur' where roll_number=10";
	//step 4)Create the Jdbc statement using Connection
		Statement statement = connection.createStatement();
	//step 5)Submit the SQL statement to Database using Jdbc statement
		int record = statement.executeUpdate(query);
	//step 6)Process the result
		if(record==1) {
			System.out.println("record updated");
		}else {
			System.out.println("record not updated");
		}
	//step 7)Close the resources
		JdbcUtils.closeResource(statement, connection);
}
}
