package com.jdbc.statement.types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.operationV2.JdbcUtils;

public class DeleteOperation {
public static void main(String[] args) throws SQLException {
	Connection connection = JdbcUtils.getMysqlConnection();
	String query="delete from student where roll_number=111";
	PreparedStatement preparedStatement = connection.prepareStatement(query);
	int record = preparedStatement.executeUpdate();
	if(record==1) {
		System.out.println("deleted");
	}else {
		System.out.println("not");
	}
	JdbcUtils.closeResource(preparedStatement, connection);
}
}
