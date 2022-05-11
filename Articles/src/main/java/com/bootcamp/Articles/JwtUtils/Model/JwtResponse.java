package com.bootcamp.Articles.JwtUtils.Model;

import java.io.Serializable;

import lombok.Getter;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 4757319588345813986L;
	@Getter private final String token;
	
	public JwtResponse(String t) {
		token = t;
	}
}
