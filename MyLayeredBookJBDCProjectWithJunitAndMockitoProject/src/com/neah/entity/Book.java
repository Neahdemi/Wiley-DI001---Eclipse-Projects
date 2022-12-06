package com.neah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Book {
	
	private int bookId;
	private int noOfCopies;
	private String authorName;
	private String bookName;

}
