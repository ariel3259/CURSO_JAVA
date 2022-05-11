package com.bootcamp.Articles.JwtUtils.Model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class JwtUsers implements Serializable{

	private static final long serialVersionUID = -6025807790450269623L;
	@Getter @Setter private String username;
	@Getter @Setter private String password;
		
	public JwtUsers(String u, String p) {
		username = u;
		password = p; 
	}
}
