package com.neah.client;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neah.presentation.EmployeePresentation;
import com.neah.presentation.EmployeePresentationImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//ApplicationContext springContainer=new ClassPathXmlApplicationContext("employee.xml");
		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("presentation");
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
		}

	}

}