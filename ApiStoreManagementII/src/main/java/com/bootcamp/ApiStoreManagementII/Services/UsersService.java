package com.bootcamp.ApiStoreManagementII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.Users;
import com.bootcamp.ApiStoreManagementII.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Users> getAll(){
		return repository.findAll();
	}
	
	public boolean save(Users user) {
		if(repository.existsByEmail(user.getEmail())) return false;
		String passwordHashed = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHashed);
		repository.save(user);
		return true;
	}
	
	public boolean update(Users user) {
		if(!repository.existsById(user.getId())) return false;
		String passwordHashed = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHashed);
		repository.save(user);
		return true;
	}
	
	public boolean delete(long id) {
		if(!repository.existsById(id)) return false;
		repository.deleteById(id);
		return true;
	}
}
