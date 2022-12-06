package com.nat.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nat.entity.Book;
import com.nat.persistence.BookDaoImpl;

class BookTest {

	BookDaoImpl bookDaoImpl;
	
	//dont need b4 and after all 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl = new BookDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl = null;
	}

	@Test
	void testInsertRecord() {
		assertEquals(1, bookDaoImpl.insertRecord(new Book(116, 2, "smth", "else")));
	}
	
	@Test
	void testGetAllEntries() {
		assertTrue(bookDaoImpl.getAllEntries().size()>0);
	}
	
	//can also do with AssertEquals with input 1, then need to have the equals function
	//in the book class- can do it by adding @equals and hashcode into the entity (book)- 
	//then returns the new book with correct properties
	//and the input is just the search records method of the dao 
	@Test 
	void testSearchRecords() {
		assertTrue(bookDaoImpl.searchRecords(101)!=null);
	}	

	@Test 
	void testUpdateRecords() {
		assertTrue(bookDaoImpl.updateRecord(new Book(101, 78, "new", "update"))>0);
	}
	
	//better to test the update in a different way- want to check for a specific field update 
	//and do assert equals to see if it has been updated correctly 


}
