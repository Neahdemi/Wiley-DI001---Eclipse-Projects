package com.neah.persistence;

import java.util.Collection;
//import java.util.List;

import com.neah.entity.Book;

public interface BookDao {
	
	Collection<Book>getAllRecords();
	
	Book searchRecord(int id);
	
	int addBook(Book book);

}
