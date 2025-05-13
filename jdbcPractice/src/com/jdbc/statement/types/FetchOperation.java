package com.jdbc.statement.types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.operationV2.JdbcUtils;

public class FetchOperation {
public static void main(String[] args) throws SQLException {
	Connection connection = JdbcUtils.getMysqlConnection();
	String query="select * from student";
	PreparedStatement preparedStatement = connection.prepareStatement(query);
	ResultSet resultSet = preparedStatement.executeQuery();
	while(resultSet.next()) {
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
	}
	JdbcUtils.closeResource(preparedStatement, connection,resultSet);
}
}
