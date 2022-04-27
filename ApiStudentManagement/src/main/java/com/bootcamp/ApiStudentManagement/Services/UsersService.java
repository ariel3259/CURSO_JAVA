package com.bootcamp.ApiStudentManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStudentManagement.Model.Users;
import com.bootcamp.ApiStudentManagement.Repository.UsersRepository;


@Service
public class UsersService {
	
	@Autowired	
	private UsersRepository ur;
	
	@Autowired
	private PasswordEncoder pe;
	
	
	public List<Users> getAllUses(){
		return (List<Users>) ur.findAll();
	}
	
	public boolean saveUser( Users user) {
		if(ur.existsByUsername(user.getUsername())) return false;
		String passwordHashed = pe.encode(user.getPassword());
		user.setPassword(passwordHashed);
		ur.save(user);
		return true;
	}
	
	public boolean editUser(Users user) {
		if(!ur.existsById(user.getId())) return false;
		String passwordHashed = pe.encode(user.getPassword());
		user.setPassword(passwordHashed);
		ur.save(user);
		return true;
	}
	
	public boolean deleteUser(int id) {
		if(!ur.existsById(id)) return false;
		ur.deleteById(id);
		return true;
	}
	
	public Users getOneUser(int id) {
		if(!ur.existsById(id)) return null;
		return ur.findById(id).get();
	}
	
}
