package com.boocamp.ProductsManagementApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boocamp.ProductsManagementApi.Model.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
	
	@Query(value = "SELECT * FROM clients c WHERE c.state=true", nativeQuery=true)
	public List<Clients> findAll();
	
	@Modifying
	@Query(value = "UPDATE clients c SET c.state = false WHERE c.id = :id", nativeQuery=true)
	public void deleteById(@Param("id") Long id);
}
