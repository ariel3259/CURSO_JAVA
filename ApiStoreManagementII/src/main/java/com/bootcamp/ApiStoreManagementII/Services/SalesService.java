package com.bootcamp.ApiStoreManagementII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.Clients;
import com.bootcamp.ApiStoreManagementII.Model.Sales;
import com.bootcamp.ApiStoreManagementII.Repository.ClientsRepository;
import com.bootcamp.ApiStoreManagementII.Repository.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository repository;
	
	@Autowired 
	private ClientsRepository repositoryClient;
	
	public List<Sales> getAll(){
		return repository.findAll();
	}
	
	public Sales getByTicket(int ticket) {
		if(!repository.existsByTicket(ticket)) return null;
		return repository.findByTicket(ticket);
	}
	
	public List<Sales> getByClient(int dni){
		if(!repositoryClient.existsByDni(dni)) return null;
		Clients client = repositoryClient.findByDni(dni);
		return repository.findByClient(client);
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
