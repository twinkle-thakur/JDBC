package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

//Serealization we'll discuss later

//rowset is advance version of result set to fetch data with scrollable(backward)+updatable feature
public class RowSetExample {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//step 1)Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/test");
        rowSet.setUsername("root");
        rowSet.setPassword("khushi1404");
     //   rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
     //   rowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
		String query="SELECT roll_number, stu_name, college FROM student";
		rowSet.setCommand(query);
		rowSet.execute();
		while(rowSet.next()) {
			System.out.println(rowSet.getInt("roll_number")+" "+rowSet.getString("stu_name")+
					" "+rowSet.getString("college"));
		}
		System.out.println("***********");
		while(rowSet.next()) {
			System.out.println(rowSet.getInt("roll_number")+" "+rowSet.getString("stu_name")+
					" "+rowSet.getString("college"));
		}
		
		rowSet.absolute(3);
		System.out.println(rowSet.getInt("roll_number")+" "+rowSet.getString("stu_name")+
				" "+rowSet.getString("college"));
		
		rowSet.updateString("stu_name","Tulsi");
		rowSet.updateString("college","IIT Patna");
		rowSet.updateInt("roll_number",333);
		rowSet.updateRow();
		rowSet.absolute(3);
		System.out.println("***************");
		System.out.println(rowSet.getInt("roll_number")+" "+rowSet.getString("stu_name")+
				" "+rowSet.getString("college"));
}
}
