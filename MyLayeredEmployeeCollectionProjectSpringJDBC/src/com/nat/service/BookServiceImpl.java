package com.nat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nat.entity.Book;
import com.nat.persistence.BookDao;
import com.nat.persistence.BookDaoImpl;

@Component("service")
public class BookServiceImpl implements BookService{

	//getting info from Dao layer - instanitaing- later change 
	//with dependency injection 
	
	//private BookDao bookDao = new BookDaoImpl();
	@Autowired
	private BookDao bookDao;
	
//	public BookServiceImpl(@Autowired BookDao bookDao) {
//		super();
//		this.bookDao = bookDao;
//	}
	
	//comment this out for spring
	//public BookServiceImpl() {
	//	
	//}
	
	//setters and getters (can also just declare bookBdao var and 
	//annotate as @Setter)
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

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
		//Book myBook = bookDao.searchRecords(book.getId());  //commented out this stuff as its before adding the JDBC 
		
		int rows = bookDao.updateRecord(book);
		if(rows == 0) {
			//bookDao.insertRecord(book);
			return false;
		} else
			return true;
	}
	
}
