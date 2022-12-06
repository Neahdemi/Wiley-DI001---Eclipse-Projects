package com.neah.service;

import java.util.Collection;

import com.neah.entity.Book;
import com.neah.persistence.BookDao;
import com.neah.persistence.BookDaoImpl;

import lombok.Setter;

import com.neah.entity.Book;

public class BookServiceImpl implements BookService{
	
	//private BookDao bookDao=new BookDaoImpl();
	
	//Service will request persistence layer for all data needs
	@Setter
	private BookDao bookDao;
	

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllRecords(); 
	}

	@Override
	public Book searchBookById(int id) {
		return bookDao.searchRecord(id);
	}

	@Override
	public boolean addNewBook(Book book) {
//		Book bookToAdd = bookDao.searchRecord(book.getBookId());
//		if (bookToAdd != null) {
//			return false;
//		}
//		bookDao.addBook(book);
//		return true;
		
		if(bookDao.addBook(book)>0)
			return true;
		return false;
	}
}


