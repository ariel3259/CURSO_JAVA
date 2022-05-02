package com.bootcamp.VentaDeAutos.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.VentaDeAutos.Model.SaleCar;

@Service
public class SaleCarService {
	
	private List<SaleCar> carSelled = new ArrayList<>();
	
	@Autowired
	private CarsService cars;
	
	public int generateSell(SaleCar sell, int idCar) {
		sell.setTicket( carSelled.size() + 1);
		sell.setCar(cars.getOne(idCar));
		carSelled.add(sell);
		return sell.getTicket();
	}
}
