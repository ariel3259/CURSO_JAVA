package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public Users getOneUser(int id) {
		return usersRepository.findById(id).get();
	}
	
	public boolean saveUser(Users user) {
		if(usersRepository.existsByUsername(user.getUsername())) return false;
		usersRepository.save(user);
		return true;
	}
	
	public boolean updateUser(Users user) {
		if(!usersRepository.existsById(user.getId())) return false;
		usersRepository.save(user);
		return true;
	}
	
	public boolean deleteUser(int id) {
		if(!usersRepository.existsById(id)) return false;
		usersRepository.deleteById(id);
		return true;
	}
}
