package com.nat.database;

import java.util.LinkedHashMap;
import java.util.Map;

import com.nat.entity.Book;

public class BookDatabase {
	static private Map<Integer, Book> bookList=new LinkedHashMap<Integer, Book>();
	
	static {
		bookList.put(101, new Book(101, 45, "Natalia", "Hello"));
		bookList.put(102, new Book(102, 300, "Neah", "Dune"));
		bookList.put(103, new Book(103, 9000, "Nico", "World Maps"));
		bookList.put(104, new Book(104, 9087, "Bob", "Algebra and Analysis"));
		bookList.put(105, new Book(105, 5, "Sujata", "Be Bold"));
	}

	public static Map<Integer, Book> getBookList() {
		return bookList;
	}

}
