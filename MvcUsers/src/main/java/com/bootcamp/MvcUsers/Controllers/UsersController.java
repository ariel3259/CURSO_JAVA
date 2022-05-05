package com.bootcamp.MvcUsers.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.MvcUsers.Model.ResponseMessage;
import com.bootcamp.MvcUsers.Model.Users;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService service;
	
	@GetMapping
	public String showGetAll(Model model) {
		List<Users> users = service.getAll();
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/create")
	public String showCreateUser(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "create_user";
	}
	
	@PostMapping("/create")
	public String createUser(@Validated @ModelAttribute("user") Users user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) return "create_user.html";
		ResponseMessage response = service.save(user);
		redirectAttributes.addFlashAttribute("message", response.getMsg());
		if(response.getStatus() == 400) redirectAttributes.addFlashAttribute("status", "failed");
		else redirectAttributes.addFlashAttribute("status", "success");
		return "redirect:/users";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateUser(@PathVariable("id") long id, Model model) {
		Users userToUpdate = service.getOne(id);
		model.addAttribute("user", userToUpdate);
		return "update_user";
	}
	
	@PostMapping("/update")
	public String showUpdateUser(@Validated @ModelAttribute("user") Users user, BindingResult result) {
		if(result.hasErrors()) return "update_user";
		service.update(user);
		return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		service.delete(id);
		return "redirect:/users";
	}
}
