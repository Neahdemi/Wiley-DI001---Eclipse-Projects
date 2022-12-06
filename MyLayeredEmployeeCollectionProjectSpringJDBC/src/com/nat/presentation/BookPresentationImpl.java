package com.nat.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.nat.entity.Book;
import com.nat.service.BookService;
import com.nat.service.BookServiceImpl;

@Component("pres")
public class BookPresentationImpl implements BookPresentation {

	//need the service layer (always private here - but later change to dependecy injection)
	//private BookService bookService = new BookServiceImpl();
	//here we are working with the annotation configuration file for IOC 
	@Autowired
	@Qualifier("service")
	private BookService bookService;
	
	//public BookPresentationImpl(BookService bookService) {
	//	super();
	//	this.bookService = bookService;
	//}
	
//	public BookPresentationImpl() {
//		
//	}
	
	//can do with setter injection instead 
	//@Autowired
	//@Qualifier("service")  //this is optional because only 1 candidate anyway- if there was multiple implementations of bookService
	//then can use qualifier to specify 
//	public void setBookService(BookService bookService) {
//		this.bookService = bookService;
//	}
	
	
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Book Management System");
		System.out.println("1. List All Books");
		System.out.println("2. Search Book By ID");
		System.out.println("3. Add New Book");
		System.out.println("4. Update a book's Information");
		System.out.println("5. Exit");
		System.out.println("============================");
	}
	
	@Override
	public void performMenu(int choice) {
		Scanner sc = new Scanner(System.in);  //then client asks for choice 
		
		switch(choice) {
		case 1:
			Collection<Book> books = bookService.getAllBooks();
			for (Book book : books) {
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
			
			System.out.println("Enter book id : ");
			newBook.setId(sc.nextInt());
			System.out.println("Enter book copies : ");
			newBook.setCopies(sc.nextInt());
			System.out.println("Enter book Author Name : ");
			newBook.setAuthorName(sc.next());
			System.out.println("Enter book Name : ");
			newBook.setBookName(sc.next());
			
			if(bookService.addBook(newBook)) {
				System.out.println("Book successfully added");
			}else {
				System.out.println("book with id " + newBook.getId() + " already exists");
			}
			break;
		case 4:
			Book updatedBook = new Book();
			
			System.out.println("Please enter book ID of book information to update : ");
			updatedBook.setId(sc.nextInt());
			System.out.println("Enter new number of book copies : ");
			updatedBook.setCopies(sc.nextInt());
			System.out.println("Enter new book Author Name : ");
			updatedBook.setAuthorName(sc.next());
			System.out.println("Enter new book Name : ");
			updatedBook.setBookName(sc.next());
			
			if(bookService.updateBook(updatedBook))
				System.out.println("Book information updated successfully");
			else 
				System.out.println("Book ID " + updatedBook.getId() + " does not exist");
			break;
		case 5:
			System.out.println("Thanks for using the book manager system!");
			System.exit(0);  
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
	}
	
}
