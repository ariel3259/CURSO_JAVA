package com.bootcamp.Articles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Configure {
	
	@Bean
	public PasswordEncoder pd() {
		return new BCryptPasswordEncoder();
	}
}
