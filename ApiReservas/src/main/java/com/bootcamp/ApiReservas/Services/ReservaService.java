package com.bootcamp.ApiReservas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiReservas.Model.Reserva;
import com.bootcamp.ApiReservas.Repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repository;
	
	public List<Reserva> getAll(){
		return repository.findAll();
	}
	
	public void save(Reserva reserva) {
		repository.save(reserva);
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
}
