package com.bootcamp.Templates.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Services.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService us;
	
	@GetMapping
	public String getAllUsers(Model model) {
		
		model.addAttribute("users", us.getAllUsers());
		return "index";
	}
	
	@GetMapping("/create") 
	public String showFormUser(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "create_user";
	}
	
	@PostMapping("/create")
	public String saveUser(@ModelAttribute("user") Users user) {
		if(user.getId() == 0) us.saveUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		Users user = us.getOneUser(id);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@ModelAttribute("user") Users user, @PathVariable("id") int id) {
		user.setId(id);
		us.saveUser(user);
		return "redirect:/";
	}
}
