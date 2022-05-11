package com.bootcamp.ApiStoreManagementII.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiStoreManagementII.Model.Sales;
import com.bootcamp.ApiStoreManagementII.Model.SalesDetails;

import ch.qos.logback.core.net.server.Client;

@Repository
public interface SalesDetailsRepository extends JpaRepository<SalesDetails, Long> {
	public List<SalesDetails> findBySale(Sales sale);
	public List<SalesDetails> findByClient(Client client);
}
