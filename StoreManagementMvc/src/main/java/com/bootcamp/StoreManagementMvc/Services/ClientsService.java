package com.bootcamp.StoreManagementMvc.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.StoreManagementMvc.Interfaces.IClientsService;
import com.bootcamp.StoreManagementMvc.Model.Clients;
import com.bootcamp.StoreManagementMvc.Repository.ClientsRepository;

@Service
@Transactional
public class ClientsService implements IClientsService {

	@Autowired
	private ClientsRepository clientsRepository;
	
	@Override
	public List<Clients> getAll() {
		return clientsRepository.findAll();
	}

	@Override
	public Clients getOne(int id) {
		if(!clientsRepository.existsById(id)) return null;
		return clientsRepository.findById(id).get();
	}

	@Override
	public void save(Clients client) {
		// TODO Auto-generated method stub
		if(clientsRepository.existsByDni(client.getDni()) || clientsRepository.existsByEmail(client.getEmail())) return;
		clientsRepository.save(client);
	}

	@Override
	public void update(Clients client) {
		if(!clientsRepository.existsById(client.getId())) return;
		clientsRepository.save(client);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if(!clientsRepository.existsById(id)) return;
		clientsRepository.deleteById(id);
	}

}
