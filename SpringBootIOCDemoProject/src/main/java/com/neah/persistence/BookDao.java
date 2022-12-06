package com.neah.persistence;

import java.util.Collection;

import com.neah.entity.Book;

public interface BookDao {

	//inserting records
	int insertRecord(Book book);
	
	//to insert, also need to search the records, via id
	Book searchRecords(int id);
	
	//getting all records
	Collection<Book> getAllEntries();
	
	//update a record
	int updateRecord(Book book);
	
	int deleteRecord(int id);

	int updateField(int id, int copies);
}
