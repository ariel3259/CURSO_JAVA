package com.bootcamp.Articles.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bootcamp.Articles.Model.Users;
import com.bootcamp.Articles.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder bcrypt;
	
	public boolean register(Users user) {
		if(repository.existsByUsername(user.getUsername())) return false;
		String passwordHashed = bcrypt.encode(user.getPassword());
		user.setPassword(passwordHashed);
		repository.save(user);	
		return true;
	}
	
}
