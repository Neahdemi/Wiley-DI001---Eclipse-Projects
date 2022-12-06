package com.neah.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.neah")
@EntityScan(basePackages = "com.neah.entity")
@EnableJpaRepositories(basePackages = "com.neah.model.persistence")
public class CustomerLayeredSpringbootMvcProject1Application /* implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(CustomerLayeredSpringbootMvcProject1Application.class, args);
	}

}
