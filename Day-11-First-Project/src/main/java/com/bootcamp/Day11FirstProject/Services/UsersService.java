package com.bootcamp.Day11FirstProject.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bootcamp.Day11FirstProject.Model.Users;

@Service
public class UsersService {

	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * 
	 * @return A list of all users 
	 */
	public List<Users> getUsers(){
		String querySelect = "SELECT * FROM `users`";
		List<Users> allUsers = jdbc.query(querySelect, BeanPropertyRowMapper.newInstance(Users.class));
		return allUsers;
	}
	
	/**
	 * 
	 * @param dni to find an user
	 * @return 
	 */
	public Users getUserByDni(int dni) {
		String querySelectByDni = "SELECT * FROM `users` WHERE `dni` = ?";
		Object[] params = {dni};
		Users user = jdbc.queryForObject(querySelectByDni, BeanPropertyRowMapper.newInstance(Users.class), params);
		return user;
	}
	
	/**
	 * 
	 * @param user that saves at database
	 * @return message
	 */
	public String saveUser(Users user) {
		String queryInsert = "INSERT INTO `users`(`name`, `last_name`, `dni`) VALUE(?, ?, ?)";
		Object[] params = {user.getName(), user.getLastName(), user.getDni()};
		try {
			int result = jdbc.update(queryInsert, params);
			if(result > 0) return "Added an user";
			else return "Failed to save an user";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "Something is wrong";
		}
	}
	
	/**
	 * 
	 * @param user to modifies an existing user
	 * @return message
	 */
	public String modifyUser(Users user){
		String queryUpdate = "UPDATE `users` SET `name` = ?, `last_name` = ?, `dni` = ? WHERE `id` = ?";
		Object[] params = {user.getName(), user.getLastName(), user.getDni(), user.getId()};
		try {
			int result = jdbc.update(queryUpdate, params);
			if(result > 0) return "Modified an user";
			else return "Failed to modify an user";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "Something is wrong";
		}
	}
	
	/**
	 * 
	 * @param id to delete an user
	 * @return message
	 */
	public String deleteUser(int dni) {
		String queryDelete = "DELETE FROM `users` WHERE `dni` = ?";
		Object[] params = {dni};
		try {
			int result = jdbc.update(queryDelete, params);
			if(result > 0) return "Deleted an user";
			else return "Failed to delete an user";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "Something is wrong";
		}
	}
}
