package com.bootcamp.ApiReservas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bootcamp.ApiReservas.Model.Users;
import com.bootcamp.ApiReservas.Services.UsersService;

@SpringBootTest
class ApiReservasApplicationTests {

	@Autowired
	private UsersService service;
	
	@Autowired
	private PasswordEncoder pe;

	@Test
	void contextLoads() {
		Users user = new Users( "arielS", "ariel@algo.com", pe.encode("1234"));
		Users user2 = new Users("Misael", "misael@algo.com", pe.encode("1234"));
		
		service.save(user2);
		service.save(user);
		
	}

}
