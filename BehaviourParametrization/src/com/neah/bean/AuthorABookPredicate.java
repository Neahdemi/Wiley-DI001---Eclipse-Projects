package com.neah.bean;

public class AuthorABookPredicate implements BookPredicate {

	@Override
	public boolean test(Book book) {
		
		return book.getAuthorName().equals("Author A");
	}

}