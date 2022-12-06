package com.neah.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.neah.persistence.BookDao;
import com.neah.service.BookServiceImpl;
import com.neah.entity.Book;
import com.neah.service.BookService;



class BookServiceTest {
	
	private BookServiceImpl bookServiceImpl;
	private BookDao bookDao;

	@BeforeEach
	void setUp() throws Exception {
		bookServiceImpl = new BookServiceImpl();
		
		bookDao = Mockito.mock(BookDao.class);
		bookServiceImpl.setBookDao(bookDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddNewBook() {
		when(bookDao.addBook(new Book(111, 300, "Mason", "Amazing"))).thenReturn(1);
		
		assertTrue(bookServiceImpl.addNewBook(new Book(111, 300, "Mason", "Amazing")));
	}
	@Test
	void testAddNewBook1() {
		when(bookDao.addBook(new Book(111, 300, "Mason", "Amazing"))).thenReturn(0);
		
		assertFalse(bookServiceImpl.addNewBook(new Book(111, 300, "Mason", "Amazing")));
	}

}
