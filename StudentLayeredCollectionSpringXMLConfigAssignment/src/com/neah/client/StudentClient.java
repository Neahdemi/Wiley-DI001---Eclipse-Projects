package com.neah.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neah.presentation.StudentPresentation;
import com.neah.presentation.StudentPresentationImpl;

public class StudentClient {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
//		EmployeePresentation employeePresentation=new EmployeePresentationImpl();
//		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		ApplicationContext springContainer=new ClassPathXmlApplicationContext("studentConfig.xml");
		StudentPresentation studentPresentation=(StudentPresentation)springContainer.getBean("studentPresentation");
		while(true) {
			studentPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			studentPresentation.performMenu(choice);
		}

	}

}