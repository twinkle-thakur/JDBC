package com.jdbc.project.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BookUtils {
	private static final String DRIVER_CLASS;
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	static {
		ResourceBundle rb = ResourceBundle.getBundle("user");//to access from file user properties
		DRIVER_CLASS = rb.getString("user.driverclass");
		URL = rb.getString("user.url");
		USER = rb.getString("user.user");
		PASSWORD = rb.getString("user.password");

		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static boolean verifyUser() {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter your user name");
		String userName = sc.nextLine();
		System.out.println("please enter your password");
		String password = sc.nextLine();
		if(userName.equals(USER)&&password.equals(PASSWORD)) {
			return true;
		}
		return false;
	}
	public static Connection getDataBaseConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 3)Close the resources
	public static void closeResource(Statement st, Connection con) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeResource(Statement st, Connection con, ResultSet rs) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
