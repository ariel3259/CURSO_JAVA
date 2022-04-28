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

import com.bootcamp.Templates.Model.Subjects;
import com.bootcamp.Templates.Services.SubjectsService;

@Controller
@RequestMapping("/subjects")
public class SubjectsController {
	
	@Autowired
	private SubjectsService subjectService;
	
	@GetMapping
	public String getAllSubjects(Model model){
		List<Subjects> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "/subjects/index";
	}
	
	@GetMapping("/create")
	public String showCreateSubject(Model model) {
		Subjects subject = new Subjects();
		model.addAttribute("subject", subject);
		return "/subjects/create_subject";
	}
	
	@PostMapping("/create")
	public String createSubject(@ModelAttribute("subject") Subjects subject) {
		subjectService.saveSubject(subject);
		return "redirect:/subjects";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateSubject(@PathVariable("id") int id, Model model) {
		Subjects subject = subjectService.getOne(id);
		model.addAttribute("subject", subject);
		return "/subjects/update_subject";
	}
	
	@PostMapping("/update/{id}")
	public String updateSubject(@PathVariable("id") int id, @ModelAttribute("subject") Subjects subject) {
		subject.setId(id);
		subjectService.editSubject(subject);
		return "redirect:/subjects";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSubject(@PathVariable("id") int id){
		subjectService.deleteSubject(id);
		return "redirect:/subjects";
	}
}
