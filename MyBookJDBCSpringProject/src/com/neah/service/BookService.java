package com.neah.service;

import java.util.Collection;

import com.neah.entity.Book;

public interface BookService {
	
	//adding a book
		boolean addBook(Book book);
		
		//to add a book, must search for book via id 
		Book searchBook(int id);
		
		Collection<Book> getAllBooks();
		
		Book searchBookById(int id);
		
		//updating a book information 
		boolean updateBook(Book book);
		
		boolean updateCopies(int id, int copies);
		
		boolean deleteBook(int id);

}
