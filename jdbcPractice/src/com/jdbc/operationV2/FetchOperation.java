package com.jdbc.operationV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchOperation {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//step 1)Load the driver
		
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	try {
		connection = JdbcUtils.getMysqlConnection();
		// step3. prepare the SQL statement
		String quary = "select * from student";
		// step4. create the JDBC statement using connection
		statement = connection.createStatement();
		// step5. submit the SQL statement using JDBC statement
		resultSet = statement.executeQuery(quary);
		// step6. process the result
		if (resultSet != null) {
			while (resultSet.next()) {
				System.out
						.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}
		}
		// step7. close the resources
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JdbcUtils.closeResource(statement, connection, resultSet);
	}
}
}
