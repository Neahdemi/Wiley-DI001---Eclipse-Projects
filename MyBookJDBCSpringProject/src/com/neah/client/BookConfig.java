package com.neah.client;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import com.neah.persistence.BookDaoImpl;
//import com.neah.presentation.BookPresentationImpl;
//import com.neah.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.neah")
public class BookConfig {
	
	@Bean(name = "mySqlDataSource")
	 public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/wileyDI001");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("DALtonENzo007!");//change pwd
        return dataSource;
      }
	
	 @Bean
     public JdbcTemplate getTemplate() {
       return new JdbcTemplate(dataSource());
     }


}