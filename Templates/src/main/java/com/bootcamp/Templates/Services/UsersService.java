package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAll(){
		return usersRepository.findAll();
	}
	
	public Page<Users> getAll(int pagNum, int pageSize){
		Pageable length = PageRequest.of(pagNum - 1, pageSize);
		return usersRepository.findAll(length);
	}
	
	public Users getOne(int id) {
		return usersRepository.findById(id).get();
	}
	
	public boolean save(Users user) {
		if(usersRepository.existsByUsername(user.getUsername())) return false;
		user.setState(true);
		usersRepository.save(user);
		return true;
	}
	
	public boolean update(Users user) {
		if(!usersRepository.existsById(user.getId())) return false;
		user.setState(true);
		usersRepository.save(user);
		return true;
	}
	
	public boolean delete(int id) {
		if(!usersRepository.existsById(id)) return false;
		usersRepository.deleteById(id);
		return true;
	}
}
