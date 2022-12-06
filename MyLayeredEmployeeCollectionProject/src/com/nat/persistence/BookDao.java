package com.nat.persistence;

import java.util.Collection;

import com.nat.entity.Book;

public interface BookDao {

	//inserting records
	int insertRecord(Book book);
	
	//to insert, also need to search the records, via id
	Book searchRecords(int id);
	
	Collection<Book> getAllEntries();
	

}
