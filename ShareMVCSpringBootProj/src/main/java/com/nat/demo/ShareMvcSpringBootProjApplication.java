package com.nat.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.nat")
@EntityScan(basePackages = "com.nat.entity")
@EnableJpaRepositories(basePackages = "com.nat.persistence")
public class ShareMvcSpringBootProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareMvcSpringBootProjApplication.class, args);
	}

}
