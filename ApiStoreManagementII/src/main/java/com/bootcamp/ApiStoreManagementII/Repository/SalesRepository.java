package com.bootcamp.ApiStoreManagementII.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiStoreManagementII.Model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
	public Sales findByTicket(int ticket);
	public boolean existsByTicket(int ticket);
}
