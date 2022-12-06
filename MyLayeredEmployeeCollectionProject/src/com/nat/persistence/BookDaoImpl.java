package com.nat.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

//import com.nat.database.BookDatabase;  //no need as now we using JDBC (with MySQL)
import com.nat.entity.Book;


@Component("dao")
public class BookDaoImpl implements BookDao {

	//inserting a record of the book 
	@Override
	public int insertRecord(Book book) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfirstdatabase", "root", "skittles");
			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?, ?, ?, ?)");
			
			preparedStatement.setInt(1, book.getId());
			preparedStatement.setInt(2, book.getCopies());
			preparedStatement.setString(3, book.getBookName());
			preparedStatement.setString(4, book.getAuthorName());
			
			rows = preparedStatement.executeUpdate();  //returns the number of rows given by the query (0 if id already exists
			//as id = primary key and would not add a duplicate primary key into the table)
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

	//need to double check this- got errors 
	//searching the books, via the id
	@Override
	public Book searchRecords(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		Book book = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfirstdatabase", "root", "skittles");
			
			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE ID = ?");
			preparedStatement.setInt(1, id);
			
//     resultSet is pointing above first row
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
		 //returns the value which is the book 
	}

	//i am getting all the entires 
	@Override
		public Collection<Book> getAllEntries() {
			Connection connection = null;
			PreparedStatement preparedStatement;
			
			//initialise a ArrayList
			Collection<Book> bookList = new ArrayList<Book>();
		
			try {
				//register driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//connect to database
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfirstdatabase", "root", "skittles");
				
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

}
