package com.nat.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nat.persistence.BookDaoImpl;
import com.nat.presentation.BookPresentationImpl;
import com.nat.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.nat")
public class BookConfiguration {

	//@Bean(name = "dao")
	//public BookDaoImpl getPersistence() {
	//	return new BookDaoImpl();
	//}
	
	//@Bean(name = "service")
	//public BookServiceImpl getBookService() {
		//constructor injection
	//	return new BookServiceImpl(getPersistence());
	//}
	
	//@Bean(name="pres")
	//public BookPresentationImpl getBookPres() {
		//setter injection
	//	BookPresentationImpl bookPresentation = new BookPresentationImpl();
		//bookPresentation.setBookService(getBookService());
		
	//	return bookPresentation;
	//}

}