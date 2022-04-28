package com.bootcamp.CarsMvc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.CarsMvc.Model.Cars;
import com.bootcamp.CarsMvc.Services.CarsService;

@Controller
@RequestMapping("/cars")
public class CarsController {
	
	@Autowired
	private CarsService carService;
	
	@GetMapping
	public String getCars(Model model) {
		List<Cars> cars = carService.getAll();
		model.addAttribute("cars", cars);
		return "/index";
	}
	
	@GetMapping("/create")
	public String showCreateCar(Model model) {
		Cars car = new Cars();
		model.addAttribute("car", car);
		return "/create_car";
	}
	
	@PostMapping("/create")
	public String createCar(@ModelAttribute("car") Cars car) {
		carService.save(car);
		return "redirect:/cars";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateCar(Model model, @PathVariable("id") int id) {
		Cars car = carService.getOne(id);
		model.addAttribute("car", car);
		//System.out.println("Car added to model");
		return "update_car";
	}
	
	@PostMapping("/update/{id}")
	public String updateCar(@ModelAttribute("car") Cars car, @PathVariable("id") int id) {
		car.setId(id);
		carService.update(car);
		return "redirect:/cars";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCar(@PathVariable("id") int id) {
		carService.delete(id);
		return "redirect:/cars";
	}
}
