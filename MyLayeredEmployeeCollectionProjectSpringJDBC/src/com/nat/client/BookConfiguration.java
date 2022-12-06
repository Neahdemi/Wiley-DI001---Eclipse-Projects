package com.nat.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nat.persistence.BookDaoImpl;
import com.nat.presentation.BookPresentationImpl;
import com.nat.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.nat")
public class BookConfiguration {

	//@Bean(name = "dao")
	//public BookDaoImpl getPersistence() {
	//	return new BookDaoImpl();
	//}
	
	//@Bean(name = "service")
	//public BookServiceImpl getBookService() {
		//constructor injection
	//	return new BookServiceImpl(getPersistence());
	//}
	
	//@Bean(name="pres")
	//public BookPresentationImpl getBookPres() {
		//setter injection
	//	BookPresentationImpl bookPresentation = new BookPresentationImpl();
		//bookPresentation.setBookService(getBookService());
		
	//	return bookPresentation;
	//}
	
	@Bean(name = "mySqlDataSource")
	public DriverManagerDataSource getmySqlDataSource() {
		DriverManagerDataSource manager = new DriverManagerDataSource();
		manager.setDriverClassName("com.mysql.cj.jdbc.Driver");
		manager.setUrl("jdbc:mysql://127.0.0.1:3306/myfirstdatabase");
		manager.setUsername("root");
		manager.setPassword("skittles");
		return manager;
	}
	
	@Bean(name = "jdbc")
	public JdbcTemplate getJdbc(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getmySqlDataSource());
		return jdbcTemplate;
	}
	

}