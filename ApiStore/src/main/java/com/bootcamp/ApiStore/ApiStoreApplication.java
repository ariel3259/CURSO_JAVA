package com.bootcamp.ApiStore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@EnableWebMvc
@OpenAPIDefinition
@SpringBootApplication
public class ApiStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStoreApplication.class, args);
	}

}
