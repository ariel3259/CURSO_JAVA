package com.boocamp.ProductsManagementApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boocamp.ProductsManagementApi.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

	@Query(value = "SELECT * FROM products p WHERE p.state=true", nativeQuery=true)
	public List<Products> findAll();
	
	@Modifying
	@Query(value = "UPDATE products P SET p.state=FALSE WHERE p.id=:id", nativeQuery=true)
	public void deleteById(@Param("id") Long id);
	
}
