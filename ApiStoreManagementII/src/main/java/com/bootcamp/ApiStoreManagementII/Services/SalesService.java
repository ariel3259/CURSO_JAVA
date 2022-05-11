package com.bootcamp.ApiStoreManagementII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.Sales;
import com.bootcamp.ApiStoreManagementII.Repository.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository repository;
	
	public List<Sales> getAll(){
		return repository.findAll();
	}
	
	public boolean save(Sales sale) {
		if(repository.existsByTicket(sale.getTicket())) return false;
		repository.save(sale);
		return true;
	}
	
	/*
	public boolean update(Sales sale) {
		if(!repository.existsById(sale.getId())) return false;
		repository.save(sale);
		return true;
	}
	
	public boolean delete(long id) {
		if(!repository.existsById(id)) return false;
		repository.deleteById(id);
		return true;
	}*/
}
