package com.bootcamp.ApiStoreManagementII.Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.ApiStoreManagementII.Model.Products;
import com.bootcamp.ApiStoreManagementII.Model.SalesDetails;
import com.bootcamp.ApiStoreManagementII.Repository.ProductsRepository;
import com.bootcamp.ApiStoreManagementII.Repository.SalesDetailsRepository;

@Service
public class SalesDetailsService {
	
	@Autowired
	private SalesDetailsRepository repository;
	
	@Autowired
	private ProductsRepository repositoryProduct;
	
	public List<SalesDetails> getAll(){
		return repository.findAll();
	}
	
	@Transactional
	public boolean save(SalesDetails saleDetail, int codeProduct) {
		if(repositoryProduct.existsByCodeAndState(codeProduct, true)) return false;

		Products product = repositoryProduct.findByCode(codeProduct);
	
		int newStock = product.getStock() - saleDetail.getItems();
		if(newStock < 0) {
			repositoryProduct.deleteById(product.getId());
			return false;
		};
		product.setStock(newStock);
		repositoryProduct.save(product);
		saleDetail.setProduct(Arrays.asList(product));
		repository.save(saleDetail);
		return true;
	}

	
/*
	public boolean update(SalesDetails saleDetail) {
		if(!repository.existsById(saleDetail.getId())) return false;
		repository.save(saleDetail);
		return false;
	}
	
	public boolean delete(long id) {
		
	}*/
}
