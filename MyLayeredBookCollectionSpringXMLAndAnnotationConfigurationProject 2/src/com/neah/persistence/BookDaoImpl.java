package com.neah.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.List;


import com.neah.entity.Book;


public class BookDaoImpl implements BookDao{

	@Override
	public Collection<Book> getAllRecords() {
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		//initialise a ArrayList
		Collection<Book> bookList = new ArrayList<Book>();
	
		try {
			//register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//connect to database
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "DALtonENzo007!");
			
			//Query - select the stuff from the place
			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS");
			
			ResultSet  resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("ID");
				int copies = resultSet.getInt("COPIES");
				String authorName = resultSet.getString("AUTHOR_NAME");
				String bookName = resultSet.getString("BOOKNAME");
				
				bookList.add(new Book(id, copies, authorName, bookName));
			}	
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//closing the connection
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	return bookList;
	}

	@Override
	public Book searchRecord(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement;

		Book book = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "DALtonENzo007!");

			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE ID=?");

			preparedStatement.setInt(1, id);
//          resultset is pointing above first row
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int Id = resultSet.getInt("ID");
				int copies = resultSet.getInt("COPIES");
				String authorName = resultSet.getString("AUTHOR_NAME");
				String bookName = resultSet.getString("BOOKNAME");
				
				book = new Book(Id, copies, authorName, bookName);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;

	}
		

	@Override
	public int addBook(Book book) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "DALtonENzo007!");
			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?, ?, ?, ?)");
			
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setInt(2, book.getNoOfCopies());
			preparedStatement.setString(3, book.getBookName());
			preparedStatement.setString(4, book.getAuthorName());
			
			rows = preparedStatement.executeUpdate();
			
			return rows;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows;
	}

}
