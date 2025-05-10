package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.operationV2.JdbcUtils;
/*
 * getCatalogName
getColumnClassName
getColumnCount
getColumnDisplaySize
getColumnLabel
getColumnName
getColumnType
getColumnTypeName
 */
public class ResultSetInformation {
public static void main(String[] args) throws SQLException {
	Connection connection = JdbcUtils.getMysqlConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("select * from student");
	ResultSetMetaData metaData = resultSet.getMetaData();
	String catalogName = metaData.getCatalogName(1);
	System.out.println(catalogName);
	System.out.println(metaData.getColumnCount());
	String columnClassName = metaData.getColumnClassName(2);
	System.out.println(columnClassName);
	System.out.println(metaData.getColumnDisplaySize(3));
	String columnLabel = metaData.getColumnLabel(2);
	System.out.println(columnLabel);
	System.out.println(metaData.getColumnName(2));
}
}
