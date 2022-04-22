package com.bootcamp.ApiEcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class ApiEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEcommerceApplication.class, args);
	}

}
