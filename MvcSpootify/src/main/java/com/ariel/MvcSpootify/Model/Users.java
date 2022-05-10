package com.ariel.MvcSpootify.Model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private int id ;
	private String username;
	private String password;
	private Set<Role> role;
}
