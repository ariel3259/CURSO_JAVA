package com.bootcamp.MvcUsers.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.MvcUsers.Model.ResponseMessage;
import com.bootcamp.MvcUsers.Model.Users;
import com.bootcamp.MvcUsers.Model.UsersList;

@Service
public class UsersService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String urlUsers = "http://localhost:8000/api/users";
	
	public List<Users> getAll(){
		UsersList rawUserList =	restTemplate.getForObject(urlUsers, UsersList.class);
		return rawUserList.getUsersList();
	}
	
	public Users getOne(long id) {
		ResponseEntity<Users> response = restTemplate.getForEntity(urlUsers + "/" + id, Users.class);
		return response.getBody();
	}
	
	public ResponseMessage save(Users user) {
		ResponseEntity<String> response = restTemplate.postForEntity(urlUsers, user, String.class);
		return new ResponseMessage(response.getStatusCodeValue(), response.getBody());
	}
	
	public void update(Users user) {
		restTemplate.put(urlUsers, user);
	}
	
	public void delete(long id) {
		restTemplate.delete(urlUsers + "/" + id);
	}
}
