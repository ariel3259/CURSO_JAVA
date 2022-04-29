package com.bootcamp.StoreManagementMvc.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.StoreManagementMvc.Model.Clients;

@Repository
public interface ClientsRepositoryNoSql extends CrudRepository<Clients, Integer>{
	public boolean existsByDni(int dni);
	public boolean existsByEmail(String email);
}
