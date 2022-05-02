package com.bootcamp.VentaDeAutos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.VentaDeAutos.Model.Cars;
import com.bootcamp.VentaDeAutos.Model.SaleCar;

@Controller
@RequestMapping("/cars")
public class CarsController {
	
	@Autowired
	private CarsService carsService;
	
	@Autowired
	private SaleCarService saleService;

	@GetMapping
	public String GetAll(Model model){
		List<Cars> cars = carsService.getAll();
		model.addAttribute("cars", cars);
		return "index";
	}
	
	@GetMapping("/{idCar}")
	public String showSaleCar(Model model, @PathVariable("idCar") int id) {
		SaleCar sell = new SaleCar();
		model.addAttribute("sell", sell);
		model.addAttribute("idCar", id);
		return "create_sell";
	}
	
	@PostMapping("/{idCar}")
	public String saveSale(RedirectAttributes rd, @ModelAttribute("sell") SaleCar sell, @PathVariable("idCar") int idCar){
		int ticket = saleService.generateSell(sell, idCar);
		rd.addFlashAttribute("ticket", ticket);
		return "redirect:/cars";
	}
}
