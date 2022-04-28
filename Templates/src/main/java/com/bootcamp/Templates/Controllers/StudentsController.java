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

import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Services.StudentsService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	private StudentsService studentService;
	
	@GetMapping
	public String getAllStudents(Model model) {
		List<Students> allStudents = studentService.GetAllSudents();
		model.addAttribute("students", allStudents);
		return "/students/index";
	}
	
	@GetMapping("/create")
	public String showCreateStudent(Model model) {
		Students student = new Students();
		model.addAttribute("student", student);
		return "/students/create_student";
	}
	
	@PostMapping("/create")
	public String saveUserStudent(@ModelAttribute("student") Students student) {
		studentService.saveStudents(student);
		return "redirect:/students";
	}
	
	@GetMapping("/update/{id}")
	public String showModifyStudent(@PathVariable("id") int id, Model model) {
		Students student = studentService.getOne(id);
		model.addAttribute("student", student);
		return "/students/update_student";
	}
	
	@PostMapping("/update/{id}")
	public String modifyStudents(@ModelAttribute("student") Students student, @PathVariable("id") int id) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudents(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
}
