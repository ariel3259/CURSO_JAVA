package com.ariel.MvcSpootify.Controllers.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ariel.MvcSpootify.Model.Users;

@Service
public class UsersService {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void save(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		rest.postForEntity("http://localhost:8080/api/users", user, null);
	}
	
	public Users getByUsername(String userName) {
		Users user = rest.getForObject("http://localhost:8000/api/users/".concat(userName), Users.class);
		return user;
	}
	
}
