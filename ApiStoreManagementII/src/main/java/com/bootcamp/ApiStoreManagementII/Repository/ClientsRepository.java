package com.bootcamp.ApiStoreManagementII.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiStoreManagementII.Model.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
	public boolean existsByDni(int dni);
	public Clients findByDni(int dni);
}
