package com.bootcamp.ApiReservas.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiReservas.Model.Role;
import com.bootcamp.ApiReservas.Model.Users;

@Service
public class DetailsUserService implements UserDetailsService {

	@Autowired
	private UsersService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = service.getOneByUsername(username);
		if(user == null) throw new UsernameNotFoundException("User isn't exists");
		List< GrantedAuthority> authorities = new ArrayList<>();
		
		for(Role rol: user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(rol.getRole()));	
		}
		
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
