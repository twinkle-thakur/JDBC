package com.jdbc.operationV2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOperationV2 {
public static void main(String[] args) throws SQLException {
	String query="insert into student values (1,'khushi','sirt')";
	
	
	try(Connection connection = JdbcUtils.getMysqlConnection();
			Statement statement = connection.createStatement();){
		int record = statement.executeUpdate(query);
		if(record==1) {
			System.out.println("inserted");
		}else {
			System.out.println("not");
		}
	}
}
}
