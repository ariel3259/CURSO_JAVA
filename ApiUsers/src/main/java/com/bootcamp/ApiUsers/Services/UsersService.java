package com.bootcamp.ApiUsers.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiUsers.Model.Users;
import com.bootcamp.ApiUsers.Repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;
	
	public List<Users> getAll(){
		return repository.findAll();
	}
	
	public Users getOne(long id) {
		return repository.findById(id).get();
	}
	
	public boolean save(Users user) {
		if(repository.existsByDni(user.getDni()) || repository.existsByPhone(user.getPhone())) return false;
		repository.save(user);
		return true;
	}
	
	public boolean update(Users user) {
		if(!repository.existsById(user.getId())) return false;
		repository.save(user);
		return true;
	}
	
	public boolean delete(long id) {
		 if(!repository.existsById(id)) return false;
		 repository.deleteById(id);
		 return true;
	}
	
}
