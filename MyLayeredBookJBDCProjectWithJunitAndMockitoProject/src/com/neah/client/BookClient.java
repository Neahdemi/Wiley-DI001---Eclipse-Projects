package com.neah.client;


import java.util.Scanner;

import com.neah.presentation.BookPresentation;
import com.neah.presentation.BookPresentationImpl;


public class BookClient {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		BookPresentation bookPresentation =  new BookPresentationImpl();
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			bookPresentation.performMenu(choice);
		}

		
		
		
		
		
	}
	

	

}
