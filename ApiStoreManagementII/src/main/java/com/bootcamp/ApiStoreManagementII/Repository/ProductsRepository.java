package com.bootcamp.ApiStoreManagementII.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiStoreManagementII.Model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	public Products findByCode(int code);
	public boolean existsByCode(int code);
}
