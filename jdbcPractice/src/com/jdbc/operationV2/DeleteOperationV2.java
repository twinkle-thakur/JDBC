package com.jdbc.operationV2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperationV2 {
public static void main(String[] args) throws SQLException {
	String query="delete from student where roll_number=12";
	
	try(Connection connection = JdbcUtils.getMysqlConnection();
			Statement statement = connection.createStatement();
			){
		int record = statement.executeUpdate(query);
		if(record>=1) {
			System.out.println("deleted");
		}
		else {
			System.out.println("not");
		}
	}
}
}
