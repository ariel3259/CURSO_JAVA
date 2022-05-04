package com.bootcamp.Templates.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.Templates.Model.Register;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Subjects;
import com.bootcamp.Templates.Requests.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private SubjectsService subjectService;
	
	@Autowired
	private StudentsService studentService;
	
	@GetMapping
	public String getAllRegisters(Model model) {
		List<Register> registers = registerService.getAll();
		
		model.addAttribute("registers", registers);
		return "/register/index";
	}
	
	@GetMapping("/create")
	public String showCreateRegister(Model model) {
		RegisterRequest registerRequest = new RegisterRequest();
		List<Subjects> subjects = subjectService.getAllSubjects();
		List<Students> students = studentService.GetAllSudents();
		model.addAttribute("subjects", subjects);
		model.addAttribute("students", students);
		model.addAttribute("registerRequest", registerRequest);
		return "/register/create_register";
	}
	
	@PostMapping("/create")
	public String createRegister(@ModelAttribute("registerRequest") RegisterRequest registerRequest) {
		int dniStudent = registerRequest.getDniStudent();
		int codeSubject = registerRequest.getCodeSubject();
		registerService.save(codeSubject, dniStudent);
		return "redirect:/register";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRegister(@PathVariable("id") int id) {
		registerService.delete(id);
		return "redirect:/register";
	}
	
}
