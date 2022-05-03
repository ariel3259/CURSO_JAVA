package com.boocamp.ProductsManagementApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boocamp.ProductsManagementApi.Model.Clients;
import com.boocamp.ProductsManagementApi.Repository.ClientsRepository;

@Service
@Transactional
public class ClientsService {
	
	@Autowired
	private ClientsRepository clientRepository;
	
	public List<Clients> getAll(){
		return clientRepository.findAll();
	}
	
	public void save(Clients client) {
		clientRepository.save(client);
	}
	
	public void update(Clients client) {
		clientRepository.save(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
