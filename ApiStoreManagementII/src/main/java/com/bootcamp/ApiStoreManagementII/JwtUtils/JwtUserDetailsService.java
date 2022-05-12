package com.bootcamp.ApiStoreManagementII.JwtUtils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.Users;
import com.bootcamp.ApiStoreManagementII.Repository.UsersRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired 
	private UsersRepository repository;
	
	//username is email
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = repository.findByEmail(username);
		if(user == null) throw new UsernameNotFoundException("User doesn't exists");
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

}
