package com.jdbc.project.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {
	public static void insert(Book b) throws SQLException {
		if (BookUtils.verifyUser()) {
			String query = "insert into mybook values (?,?,?,?,?,?)";
			try (Connection connection = BookUtils.getDataBaseConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				preparedStatement.setString(1, b.getBook_id());
				preparedStatement.setString(2, b.getBook_name());
				preparedStatement.setString(3, b.getAuthor());
				preparedStatement.setString(4, b.getPublication());
				preparedStatement.setInt(5, b.getCost());
				preparedStatement.setInt(6, b.getEdition());
				int record = preparedStatement.executeUpdate();
				if (record == 1) {
					System.out.println("Book inserted");
				} else {
					System.out.println("not");
				}
			}
		} else {
			System.out.println("Invalid user");
		}
	}

	public static void fetch() throws SQLException {
		if (BookUtils.verifyUser()) {
			String query = "select * from mybook";
			Connection connection = BookUtils.getDataBaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1) + " " + resultSet.getNString(2) + " " + " "
							+ resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " "
							+ " " + resultSet.getInt(6));
				}
			} else {
				System.out.println("it is null");
			}
		} else {
			System.out.println("Invalid user");
		}
	}
public static void fetchBookByAuthor(String author) throws SQLException {
	String query="select * from mybook where author=?";
	Connection connection = BookUtils.getDataBaseConnection();
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setString(1, author);
	ResultSet resultSet = ps.executeQuery();
	if (resultSet != null) {
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getNString(2) + " " + " "
					+ resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " "
					+ " " + resultSet.getInt(6));
		}
	} else {
		System.out.println("it is null");
	}
}
public static void fetchBookByBookId(String BookId) throws SQLException {
	String query="select * from mybook where book_id=?";
	Connection connection = BookUtils.getDataBaseConnection();
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setString(1, BookId);
	ResultSet resultSet = ps.executeQuery();
	if (resultSet != null) {
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getNString(2) + " " + " "
					+ resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getInt(5) + " "
					+ " " + resultSet.getInt(6));
		}
	} else {
		System.out.println("it is null");
	}
}
	public static void update(Book b) throws SQLException {
		if (BookUtils.verifyUser()) {
			String query = "update mybook set author=? where book_id=?";
			Connection connection = BookUtils.getDataBaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, b.getAuthor());
			ps.setString(2, b.getBook_id());
			int record = ps.executeUpdate();
			if (record == 1) {
				System.out.println("Updated");
			} else {
				System.out.println("not");
			}
		} else {
			System.out.println("Invalid user");
		}
	}

	public static void delete(String bookId) throws SQLException {
		if (BookUtils.verifyUser()) {
			String query = "delete from mybook where book_id=?";
			Connection connection = BookUtils.getDataBaseConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,bookId);
			int record = ps.executeUpdate();
			if (record == 1) {
				System.out.println("Deleted");
			} else {
				System.out.println("not");
			}
		} else {
			System.out.println("Invalid user");
		}
	}

	public static void main(String[] args) throws SQLException {
		Book book = new Book();
		book.setBook_id("A3");
		book.setBook_name("Bio");
		book.setAuthor("Om Thakur");
		book.setPublication("ktBooks");
		book.setCost(600);
		book.setEdition(3);

//		BookService.insert(book);
//		BookService.fetch();
//		BookService.update(book);
//		BookService.delete("A2");
//		BookService.fetchBookByAuthor("Twinkle");
		BookService.fetchBookByBookId("A1");
	}
}
