package com.neah.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.neah.presentation.BookPresentation;

@SpringBootApplication(scanBasePackages = "com.neah")
public class SpringBootIocDemoProjectApplication {

	public static void main(String[] args) {
			ApplicationContext springContainer= SpringApplication.run(SpringBootIocDemoProjectApplication.class, args);
			
			
			Scanner scanner=new Scanner(System.in);

			BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("presentation");
			
			while(true) {
				bookPresentation.showMenu();
				System.out.println("Enter Choice : ");
				int choice=scanner.nextInt();
				bookPresentation.performMenu(choice);
			}
			
			
			
	}

}
