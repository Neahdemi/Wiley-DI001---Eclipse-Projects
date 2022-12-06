package com.neah.persistence;

//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//import com.nat.database.BookDatabase;  //no need as now we using JDBC (with MySQL)
import com.neah.entity.Book;


@Component("dao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//inserting a record of the book 
	@Override
	public int insertRecord(Book book) {
		
	try {	
		String query = "INSERT INTO BOOKS VALUES(?, ?, ?, ?)";
		
		int rows = jdbcTemplate.update(query, book.getId(), book.getCopies(), book.getAuthorName(),
				book.getBookName());
		 return rows;
	} catch (DuplicateKeyException ex) {
		return 0;
	}
}
	//searching the books, via the id
	@Override
	public Book searchRecords(int id) {
		
		Book book = null;
		try {

			String query = "SELECT * FROM Books WHERE ID=?";
			book = jdbcTemplate.queryForObject(query, new BookRowMapper(), id);
		
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
		return book;
		 //returns the value which is the book 
	}
	
	@Override
		public Collection<Book> getAllEntries() {
			
		String query = "SELECT * FROM BOOKS";
		List<Book> book = jdbcTemplate.query(query, new BookRowMapper());
		return book;
	}

	@Override
	public int updateRecord(Book book) {
		String query = "UPDATE BOOKS SET COPIES = ?, AUTHOR_NAME = ?, BOOKNAME = ? WHERE ID = ?";
		
		int rows = jdbcTemplate.update(query, book.getCopies(), book.getAuthorName(), book.getBookName(),
				book.getId());
		
		return rows;
		
	}

	@Override
	public int updateField(int id, int copies) {
		String query = "UPDATE BOOKS SET COPIES = ? WHERE ID = ?";
		
		int rows = jdbcTemplate.update(query, copies, id);
		
		return rows;
	}
	
	@Override
	public int deleteRecord(int id) {

		String query = "DELETE FROM BOOKS WHERE ID=?";
		int rows = jdbcTemplate.update(query, id);

		return rows;
	}

	
}