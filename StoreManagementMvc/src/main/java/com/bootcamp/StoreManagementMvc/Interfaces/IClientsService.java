package com.bootcamp.StoreManagementMvc.Interfaces;

import java.util.List;

import com.bootcamp.StoreManagementMvc.Model.Clients;

public interface IClientsService {
	public List<Clients> getAll();
	public Clients getOne(int id);
	public Clients getOneByDni(int dni);
	public void save(Clients client);
	public void update(Clients client);
	public void delete(int id);
}
