package com.bootcamp.ApiStoreManagementII.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiStoreManagementII.Model.Clients;
import com.bootcamp.ApiStoreManagementII.Model.Sales;

import ch.qos.logback.core.net.server.Client;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	public Sales findByTicket(int ticket);
	public boolean existsByTicket(int ticket);
	public List<Sales> findByClient(Clients client);
}
