package com.bootcamp.Articles.Services;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bootcamp.Articles.Model.Role;
import com.bootcamp.Articles.Model.Users;
import com.bootcamp.Articles.Repository.RoleRepository;
import com.bootcamp.Articles.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder bcrypt;
	
	@Autowired
	private RoleRepository repositoryRole;
	
	@Transactional
	public boolean register(Users user) {
		if(repository.existsByUsername(user.getUsername())) return false;
		String passwordHashed = bcrypt.encode(user.getPassword());
		Role roles = repositoryRole.findByName("NORMAL");
		user.setRoles(roles);
		user.setPassword(passwordHashed);
		repository.save(user);	
		return true;
	}
	
}
