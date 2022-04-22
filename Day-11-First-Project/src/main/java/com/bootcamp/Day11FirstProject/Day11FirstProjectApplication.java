package com.bootcamp.Day11FirstProject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@OpenAPIDefinition
@EnableWebMvc
@SpringBootApplication
public class Day11FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day11FirstProjectApplication.class, args);
	}

}
