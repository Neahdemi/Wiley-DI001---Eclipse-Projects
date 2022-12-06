package com.neah.client;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.neah.persistence.EmployeeDao;
import com.neah.persistence.EmployeeDaoImpl;
import com.neah.presentation.EmployeePresentationImpl;
import com.neah.service.EmployeeServiceImpl;

@Configuration
@ComponentScan(basePackages = "com.neah")
public class EmployeeConfiguration {
  
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
//          JdbcTemplate jdbcTemplate = new JdbcTemplate();
//          jdbcTemplate.setDataSource(dataSource());
          return new JdbcTemplate(dataSource());
        }

//        @Bean
//        public EmployeeDao employeeDao(){
//          EmployeeDaoImpl bookDao = new EmployeeDaoImpl();
//          bookDao.setJdbcTemplate(jdbcTemplate());
//          return bookDao;
//        }

      }

	
