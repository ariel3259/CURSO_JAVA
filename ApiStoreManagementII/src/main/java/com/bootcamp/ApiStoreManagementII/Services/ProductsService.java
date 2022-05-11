package com.bootcamp.ApiStoreManagementII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.Products;
import com.bootcamp.ApiStoreManagementII.Repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository repository;
	
	public List<Products> getAll(){
		return repository.findAll();
	}
	
	public boolean save(Products product) {
		if(repository.existsByCode(product.getCode())) return false;
		repository.save(product);
		return true;
	}
	
	public boolean update(Products product) {
		if(!repository.existsById(product.getId())) return false;
		repository.save(product);
		return true;
	}
	
	public boolean delete(long id) {
		if(!repository.existsById(id)) return false;
		repository.deleteById(id);
		return true;
	}
}
