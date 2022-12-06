package com.neah.service;

import java.util.Collection;

import com.neah.entity.Book;

public interface BookService {
	
	Collection<Book> getAllBooks();
	
	Book searchBookById(int id);

	boolean addNewBook(Book book);

}
