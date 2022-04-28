package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository ur;
	
	public List<Users> getAllUsers(){
		return (List<Users>) ur.findAll();
	}
	
	public Users getOneUser(int id) {
		return ur.findById(id).get();
	}
	
	public boolean saveUser(Users user) {
		if(ur.existsByUsername(user.getUsername())) return false;
		ur.save(user);
		return true;
	}
}
