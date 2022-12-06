package com.neah.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.neah.persistence.StudentDao;
import com.neah.persistence.StudentDaoImpl;
import com.neah.presentation.StudentPresentationImpl;
import com.neah.service.StudentServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.neah")
public class StudentConfiguration {

	
}