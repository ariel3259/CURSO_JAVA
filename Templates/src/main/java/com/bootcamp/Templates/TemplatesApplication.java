package com.bootcamp.Templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Repository.UsersRepository;

@SpringBootApplication
public class TemplatesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TemplatesApplication.class, args);
	}
	
}
