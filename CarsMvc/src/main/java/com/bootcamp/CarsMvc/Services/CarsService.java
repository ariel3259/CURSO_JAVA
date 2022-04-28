package com.bootcamp.CarsMvc.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.CarsMvc.Model.Cars;
import com.bootcamp.CarsMvc.Repository.CarsRepository;


@Service
@Transactional
public class CarsService {
	
	@Autowired
	private CarsRepository carsRepository;
	
	public List<Cars> getAll(){
		return (List<Cars>) carsRepository.findAll();
	}
	
	public void save(Cars car) {
		carsRepository.save(car);
	}
	
	public void update(Cars car) {
		if(!carsRepository.existsById(car.getId())) return;
		carsRepository.save(car);
	}
	
	public void delete(int id) {
		if(!carsRepository.existsById(id)) return;
		carsRepository.deleteById(id);
	}
	
	public Cars getOne(int id) {
		if(!carsRepository.existsById(id)) return null;
		return carsRepository.getById(id);
	}
}
