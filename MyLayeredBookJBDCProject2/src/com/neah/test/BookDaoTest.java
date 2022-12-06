package com.neah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neah.entity.Book;
import com.neah.persistence.BookDaoImpl;

class BookDaoTest {
	
	BookDaoImpl bookDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl=new BookDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl=null;
	}

	@Test
	void testGetAllRecords() {
		assertTrue(bookDaoImpl.getAllRecords().size()>0);
	}

	@Test
	void testSearchRecord() {
		assertTrue(bookDaoImpl.searchRecord(101)!=null);
		
	}

	@Test
	void testAddBook() {
		assertEquals(1, bookDaoImpl.addBook(new Book (110, 500, "Amazing world", "Lara")));
	}

}
