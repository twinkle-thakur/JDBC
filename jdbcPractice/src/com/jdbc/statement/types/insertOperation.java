package com.jdbc.statement.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.operationV2.JdbcUtils;

public class insertOperation {
public static void main(String[] args) throws SQLException {
	//step 1)Load the driver
		//this will be automaticaly called at the time of class load
	//step 2)Establish a connection between Jdbc program and Database
	Connection connection = JdbcUtils.getMysqlConnection();
	//step 3)Prepare the SQL statement
		String query="insert into student values (14,'Twinkle','SIRT')";
	//step 4)Create the Jdbc statement using Connection
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSetMetaData metaData = statement.getMetaData();
		System.out.println(metaData.getColumnName(1));
	//step 5)Submit the SQL statement to Database using Jdbc statement
		int record = statement.executeUpdate(query);
	//step 6)Process the result
		if(record==1) {
			System.out.println("record inserted");
		}else {
			System.out.println("record not inserted");
		}
	//step 7)Close the resources
		JdbcUtils.closeResource(statement, connection);
	}	
}
