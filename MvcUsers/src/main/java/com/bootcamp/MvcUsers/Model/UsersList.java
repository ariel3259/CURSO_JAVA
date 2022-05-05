package com.bootcamp.MvcUsers.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UsersList {
	@Getter @Setter private List<Users> usersList;
	
	public UsersList() {
		usersList = new ArrayList<>();
	}
}
