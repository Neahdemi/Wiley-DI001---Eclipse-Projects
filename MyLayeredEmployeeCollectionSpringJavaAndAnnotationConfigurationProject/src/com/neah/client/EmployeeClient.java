package com.neah.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neah.presentation.EmployeePresentation;
import com.neah.presentation.EmployeePresentationImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
//		EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		
		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("empPresentation");
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
		}

	}

}