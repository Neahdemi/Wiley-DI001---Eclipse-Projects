package com.neah.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import com.neah.persistence.EmployeeDao;
import com.neah.persistence.EmployeeDaoImpl;
import com.neah.presentation.EmployeePresentationImpl;
import com.neah.service.EmployeeServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.neah")
public class EmployeeConfiguration {

	
}