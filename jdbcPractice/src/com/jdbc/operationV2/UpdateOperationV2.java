package com.jdbc.operationV2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperationV2 {
public static void main(String[] args) throws SQLException {
	String query="update student set stu_name='Twinkle' where roll_number=1";
	try(Connection connection = JdbcUtils.getMysqlConnection();
			Statement statement = connection.createStatement();){
		int record = statement.executeUpdate(query);
		if(record==1) {
			System.out.println("updated");
		}else {
			System.out.println("not");
		}
	}
}
}
