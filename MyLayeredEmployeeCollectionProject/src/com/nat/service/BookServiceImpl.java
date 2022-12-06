package com.nat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nat.entity.Book;
import com.nat.persistence.BookDao;

@Component("service")
public class BookServiceImpl implements BookService{

	//getting info from Dao layer - instanitaing- later change 
	//with dependency injection 
	
	//private BookDao bookDao = new BookDaoImpl();
	private BookDao bookDao;
	
	public BookServiceImpl(@Autowired BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}
	
	//public BookServiceImpl() {
	//	
	//}
	
	
	@Override
	public boolean addBook(Book book) {
		//Book myBook = bookDao.searchRecords(book.getId());
		
		int rows = bookDao.insertRecord(book);
		if(rows == 0) {
			return false;
		}
		else
			return true; 
	}


	//need to search for the id first, only then can add the book
	@Override
	public Book searchBook(int id) {
		return bookDao.searchRecords(id);
	}


	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllEntries();
	}
	
	@Override
	public Book searchBookById(int id) {
		return bookDao.searchRecords(id);
	}


	//updating a book - opposite functionality of adding a book-
	//if the id exists, return true 
	@Override
	public boolean updateBook(Book book) {
		Book myBook = bookDao.searchRecords(book.getId());
		if(myBook != null) {
			bookDao.insertRecord(book);
			return true;
		}
		return false;
	}
	
}
