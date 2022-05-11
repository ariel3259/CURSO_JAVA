package com.bootcamp.ApiReservas.Services;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiReservas.Model.Role;
import com.bootcamp.ApiReservas.Model.Users;
import com.bootcamp.ApiReservas.Repository.RoleRepository;
import com.bootcamp.ApiReservas.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public List<Users> getAll(){
		return repository.findAll();
	}
	
	public void save(Users user) {
		String passwordHashed = encoder.encode(user.getPassword());
		Role userRole = roleRepository.findByRole("USERS");
		user.setRoles(new HashSet<>(Arrays.asList(userRole)));
		user.setPassword(passwordHashed);
		repository.save(user);
	}
	
	public Users getOneByUsername(String username) {
		return repository.findByUsername(username);
	}
}
