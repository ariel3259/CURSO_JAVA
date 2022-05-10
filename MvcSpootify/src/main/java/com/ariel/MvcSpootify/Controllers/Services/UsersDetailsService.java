package com.ariel.MvcSpootify.Controllers.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ariel.MvcSpootify.Model.Role;
import com.ariel.MvcSpootify.Model.Users;

@Service
public class UsersDetailsService implements UserDetailsService  {

	@Autowired
	private UsersService service;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = service.getByUsername(username);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
		return buildUserForAuthentification(user, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> roles) {
		Set<GrantedAuthority> authority = new HashSet<>();
		for(Role role: roles) {
			authority.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new ArrayList<>(authority);
	}
	
	private UserDetails buildUserForAuthentification(Users user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
