package com.bootcamp.ApiStoreManagementII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.Clients;
import com.bootcamp.ApiStoreManagementII.Repository.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;
	
	public List<Clients> getAll(){
		return repository.findAll();
	}
	
	public Clients getOne(int dni) {
		return repository.findByDni(dni);
	}
	
	public boolean save(Clients client) {
		if(repository.existsByDni(client.getDni())) return false;
		repository.save(client);
		return true;
	}
	
	public boolean update(Clients client) {
		if(!repository.existsById(client.getId())) return false;
		repository.save(client);
		return true;
	}
	
	public boolean delete(long id) {
		if(!repository.existsById(id)) return false;
		repository.deleteById(id);
		return true;
	}
}
