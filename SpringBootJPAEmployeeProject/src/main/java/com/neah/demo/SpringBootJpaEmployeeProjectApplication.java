package com.neah.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.neah.presentation.EmployeePresentation;

@SpringBootApplication(scanBasePackages = "com.neah")
@EntityScan(basePackages = "com.neah.entity")
@EnableJpaRepositories(basePackages = "com.neah.persistence")
public class SpringBootJpaEmployeeProjectApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer= SpringApplication.run(SpringBootJpaEmployeeProjectApplication.class, args);
		
		Scanner scanner=new Scanner(System.in);

		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("presentation");
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
		}
	}

}
