package com.neah.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.neah.entity.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		int id = resultSet.getInt("id");
		int copies = resultSet.getInt("copies");
		String author = resultSet.getString("author_name");
		String bookName = resultSet.getString("bookName");
		
		Book book = new Book(id, copies, author, bookName);
		
		return book;
	}

}
