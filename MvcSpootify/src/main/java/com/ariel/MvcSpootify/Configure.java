package com.ariel.MvcSpootify;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configure{
	
	@Bean
	public RestTemplate restTemplates() {
		return new RestTemplate();
	}
}
