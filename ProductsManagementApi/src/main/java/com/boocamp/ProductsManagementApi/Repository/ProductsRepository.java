package com.boocamp.ProductsManagementApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boocamp.ProductsManagementApi.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

	@Query(value = "SELECT p FROM `products` p WHERE p.state=TRUE")
	public List<Products> findAll();
	
	@Query(value = "UPDATE `products` P SET p.state=FALSE WHERE p.id=:id")
	public void deleteById(@Param("id") Long id);
	
}
