package com.bootcamp.Articles.JwtUtils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootcamp.Articles.Model.Users;
import com.bootcamp.Articles.Repository.UsersRepository;

@Service
public class JwtUserDetailService implements UserDetailsService {
	
	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = repository.findByUsername(username);
		if(user == null) throw new UsernameNotFoundException(username + " doesn't exists");
		
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	
	
}
