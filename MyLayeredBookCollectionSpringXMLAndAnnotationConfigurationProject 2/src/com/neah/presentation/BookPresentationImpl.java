package com.neah.presentation;

import java.util.Collection;
import java.util.Scanner;

import com.neah.entity.Book;
import com.neah.service.BookService;
import com.neah.service.BookServiceImpl;


public class BookPresentationImpl implements BookPresentation{
	
	private BookService bookService=new BookServiceImpl();
	

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Book Library System");
		System.out.println("1. List All Books");
		System.out.println("2. Search Book By ID");
		System.out.println("3. Add New Book");
		System.out.println("4. Exit");
		System.out.println("============================");		
	}

	@Override
	public void performMenu(int choice) {
		Scanner sc = new Scanner(System.in);
		
		switch(choice){
		
		case 1: 
			Collection<Book> books = bookService.getAllBooks();
			for(Book book : books) {
				System.out.println(book);
			}
			break;
		case 2: 
			System.out.println("Please Enter Book ID: ");
			int id = sc.nextInt();
			Book book = bookService.searchBookById(id);
			if(book != null)
				System.out.println(book);
			else
				System.out.println("Book with the ID " + id + " does not exist");
			break;
		case 3: 
			Book newBook = new Book();
			System.out.println("Enter book ID : ");
			newBook.setBookId(sc.nextInt());
			System.out.println("Enter book name : ");
			newBook.setBookName(sc.next());
			System.out.println("Enter book author : ");
			newBook.setAuthorName(sc.next());
			System.out.println("Enter number of copies : ");
			newBook.setNoOfCopies(sc.nextInt());
			
			if(bookService.addNewBook(newBook))
				System.out.println("Book added");
			else
				System.out.println("Book already exists");
			break;
		case 4: 
			System.out.println("Thanks for using Book Library System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!!");
			break;
	
		}
		
	}

}
