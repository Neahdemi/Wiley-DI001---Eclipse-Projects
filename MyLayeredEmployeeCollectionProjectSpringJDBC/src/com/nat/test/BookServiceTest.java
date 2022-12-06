//package com.nat.test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import com.nat.entity.Book;
//import com.nat.persistence.BookDao;
//import com.nat.service.BookServiceImpl;
//import com.sujata.service.EmployeeServiceImpl;
//
//class BookServiceTest {
//
//	private BookServiceImpl bookServiceImpl;
//	private BookDao bookDao;
//	
//	
//	//don't need before all and after each 
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		bookServiceImpl = new BookServiceImpl();
//		
//		bookDao = Mockito.mock(BookDao.class);
//		bookServiceImpl.setBookDao(bookDao);
//		
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		//dont need to destroy the setup- as when using mockito 
//		//whenever the running, internal environment is creating test case
//		//so internally object is being created for test case class
//		//internally, environemt keeps on creating new instance
//		//so java automatically sends the object for garbage collection so we dont
//		//need to do it 
//	}
//
//	@Test
//	void testAddBook() {
//		when(bookDao.insertRecord(new Book(120, 2, "hi", "there"))).thenReturn(1);
//		
//		assertTrue(bookServiceImpl.addBook(new Book(120, 2, "hi", "there")));
//	}
//	
//	//also do the negative of each positive
//
//	@Test
//	void testSearchBook() {
//		
//		Book book = new Book(120, 2, "hi", "there");
//		
//		when(bookDao.searchRecords(120)).thenReturn(book);
//		
//		assertEquals(bookServiceImpl.searchBook(120), book);
//	}
//
//	 
//	@Test
//	void testGetAllBooks() {
//		
//		//creating a collection to test all the entries method
//		Collection<Book> collection = new ArrayList<Book>();
//		collection.add(new Book(121, 2, "hi", "there"));
//		collection.add(new Book(122, 2, "hi", "there"));
//		collection.add(new Book(123, 2, "hi", "there"));
//		
//		
//		when(bookDao.getAllEntries()).thenReturn(collection);
//		assertTrue(bookServiceImpl.getAllBooks().size()>0);
//	}
//
//	//@Test
//	//void testSearchBookById() {
//	//	fail("Not yet implemented");
//	//}
//
//	@Test
//	void testUpdateBook() {
//		Book book = new Book(120, 3, "new_hi", "there");
//		when(bookDao.updateRecord(book)).thenReturn(1);
//		assertTrue(bookServiceImpl.updateBook(book));
//	}
//
//}
