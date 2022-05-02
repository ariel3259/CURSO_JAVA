package com.bootcamp.StoreManagementMvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.StoreManagementMvc.Model.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
	public boolean existsByDni(int dni);
	public boolean existsByEmail(String email);
	public Clients findByDni(int dni);
}
