package com.jdbc.operation.dynamic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.Student;
import com.jdbc.operationV2.JdbcUtils;

public class JdbcOperation {
	//1.insert return type int

	//2.fetch all
public <T> T fetchAll() throws SQLException {
	String query="select * from student";
	List<Student> list=new ArrayList<>();
	try(Connection connection=JdbcUtils.getMysqlConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			){
		// step6. process the result
					if (resultSet != null) {
						while (resultSet.next()) {
							Student student=new Student();
							student.setRollNumber(resultSet.getInt(1));
							student.setName(resultSet.getString(2));
							student.setCollege( resultSet.getString(3));
							list.add(student);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();

				}
				return (T) list;
	}
//3.fetch by id
//4.delete record using id
//5.update record	
}



