package com.neah.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.neah.entity.Book;
import com.neah.persistence.BookDao;
import com.neah.service.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTestWithAnnotation {
	
	@InjectMocks
	private BookServiceImpl bookServiceImpl;
	
	@Mock
	private BookDao bookDao;
	private AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		/*
		 * tells mockito to scan the test class instance 
		 * for all the fields annotated with @Mock
		 * and initialise those fields as mocks
		 * 
		 */
		autoCloseable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testAddNewBook() {
		when(bookDao.addBook(new Book(111, 300, "Mason", "Amazing"))).thenReturn(0);
		
		assertFalse(bookServiceImpl.addNewBook(new Book(111, 300, "Mason", "Amazing")));
	}
	@Test
	void testAddNewBook1() {
		when(bookDao.addBook(new Book(111, 300, "Mason", "Amazing"))).thenReturn(1);
		
		assertTrue(bookServiceImpl.addNewBook(new Book(111, 300, "Mason", "Amazing")));
	}
}
