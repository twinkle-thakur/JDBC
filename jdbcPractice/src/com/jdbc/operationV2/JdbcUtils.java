package com.jdbc.operationV2;
/*these 3 steps were common therefore we created a class and in place of writing code
 *  we will just call these methods*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
//1)Load the Driver
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//2)Establish connection b/t jdbc and mysql
	public static Connection getMysqlConnection() {
		String url="jdbc:mysql://localhost:3306/test";
		Connection connection=null;
		try {
			 connection = DriverManager.getConnection(url,"root","khushi1404");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
//3)Close the resources
	public static void closeResource(Statement st,Connection con) {
		try {
			if(st!=null)
			st.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void closeResource(Statement st,Connection con,ResultSet rs) {
		try {
			if(st!=null)
			st.close();
			if(con!=null)
				con.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	
	}


