package com.jdbc.operation.dynamic;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.entity.Student;

public class Client {
	public static void main(String[] args) throws SQLException {
		JdbcOperation jdbcOperation=new JdbcOperation();
		List<Student> list=jdbcOperation.fetchAll();
		list.forEach(s->{
			System.out.println(s.getRollNumber()+" "+s.getName()+" "+s.getCollege());
		});
		
	}
}
