package com.neah.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neah.presentation.StudentPresentation;
import com.neah.presentation.StudentPresentationImpl;

public class StudentClient {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
//		EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		StudentPresentation studentPresentation=(StudentPresentation)springContainer.getBean("stuPresentation");
		while(true) {
			studentPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			studentPresentation.performMenu(choice);
		}

	}

}