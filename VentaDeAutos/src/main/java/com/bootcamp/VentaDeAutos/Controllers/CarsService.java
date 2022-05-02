package com.bootcamp.VentaDeAutos.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.VentaDeAutos.Model.Cars;

@Service
public class CarsService {
	
	private List<Cars> cars = new ArrayList<>();
	
	public CarsService() {
			cars.add(new Cars(1, "Toyota", "Fourtner", 7000));
			cars.add(new Cars(2, "Nissan", "Sedan", 4600));
			cars.add(new Cars(3, "Toyota", "Corolla", 3800));
	}
	
	public List<Cars> getAll(){
		return cars;
	}
	public Cars getOne(int id) {
		return cars.get(id - 1);
	}
}
