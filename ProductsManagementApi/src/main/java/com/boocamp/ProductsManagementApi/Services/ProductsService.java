package com.boocamp.ProductsManagementApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boocamp.ProductsManagementApi.Model.Products;
import com.boocamp.ProductsManagementApi.Repository.ProductsRepository;

@Service
@Transactional
public class ProductsService {
	
	@Autowired
	private ProductsRepository productRepository;
	
	public List<Products> getAll(){
		return productRepository.findAll();
	}
	
	public void save(Products product) {
		productRepository.save(product);
	}
	
	public void update(Products product) {
		productRepository.save(product);
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
