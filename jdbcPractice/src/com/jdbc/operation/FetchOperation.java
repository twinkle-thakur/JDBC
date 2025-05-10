package com.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchOperation {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//step 1)Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	//step 2)Establish a connection between Jdbc program and Database
		String url="jdbc:mysql://localhost:3306/test";
		Connection connection=DriverManager.getConnection(url,"root","khushi1404");
	//step 3)Prepare the SQL statement
		String query="select * from student";
	//step 4)Create the Jdbc statement using Connection
		Statement statement = connection.createStatement();
	//step 5)Submit the SQL statement to Database using Jdbc statement
		ResultSet resultSet = statement.executeQuery(query);
	//step 6)Process the result
		if(resultSet!=null) {
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			}
		}
	//ResultSet is not backward compatible once it reaches null it will not go back	
//		System.out.println("******************");
//		if(resultSet!=null) {
//			while(resultSet.next()) {
//				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
//			}
//		}
	//Therefore if we try to print 3 row it will not go back and throw exception	
//		resultSet.absolute(3);
//		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
	//step 7)Close the resources
		connection.close();
		statement.close();
}
}
