package com.bootcamp.StoreManagementMvc.Interfaces;

import java.util.List;

import com.bootcamp.StoreManagementMvc.Model.Clients;

public interface IClientsService {
	public List<Clients> getAll();
	public Clients getOne(int id);
	public Clients getOneByDni(int dni);
	public boolean save(Clients client);
	public boolean update(Clients client);
	public boolean delete(int id);
}
