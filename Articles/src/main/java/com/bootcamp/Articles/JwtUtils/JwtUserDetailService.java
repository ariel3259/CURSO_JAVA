package com.bootcamp.Articles.JwtUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootcamp.Articles.Model.Role;
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
		List< GrantedAuthority> authorities = new ArrayList<>();
		Role roles = user.getRoles();
		authorities.add(new SimpleGrantedAuthority(roles.getName()));
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
	
	
}
