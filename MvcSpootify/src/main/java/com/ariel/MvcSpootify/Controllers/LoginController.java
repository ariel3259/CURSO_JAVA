package com.ariel.MvcSpootify.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ariel.MvcSpootify.Model.Users;

@Controller
public class LoginController {
	
	
	@GetMapping({"/", "/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}
}
