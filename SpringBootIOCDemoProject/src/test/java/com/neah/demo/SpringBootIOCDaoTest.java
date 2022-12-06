package com.neah.demo;

import static org.junit.jupiter.api.Assertions.*;


import com.neah.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neah.persistence.BookDaoImpl;

@SpringBootTest
class SpringBootIOCDaoTest {
	
	@Autowired
	BookDaoImpl bookDaoImpl;



	@Test
	void testGetAllEntries() {
		assertTrue(bookDaoImpl.getAllEntries().size()>0);
	}

	@Test
	void testSearchRecords() {
		assertTrue(bookDaoImpl.searchRecords(101)!=null);
	}

	@Test
	void testInsertRecord() {
		assertEquals(1, bookDaoImpl.insertRecord(new Book(107, 533, "Amy", "The world")));
	}


}
