package com.nat.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nat.presentation.BookPresentation;

public class BookClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//BookPresentation bookPresentation=new BookPresentationImpl();
		//injection 
		AnnotationConfigApplicationContext springcontainer=new AnnotationConfigApplicationContext(BookConfiguration.class);
		
		//using the .xml config file
		//ApplicationContext springcontainer = new ClassPathXmlApplicationContext("ConfigFile.xml");
		
		BookPresentation bookPresentation = (BookPresentation) springcontainer.getBean("pres");
		
		//when changed a constructor injection to a setter injection, it went abit wrong - why?
		//its because i needed to follow the name convention- e.g. in presentation need setter to 
		//be called setBookService() then it will work - WORKS ! 
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
		}

	}

}
