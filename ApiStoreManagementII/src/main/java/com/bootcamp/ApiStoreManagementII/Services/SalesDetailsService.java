package com.bootcamp.ApiStoreManagementII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStoreManagementII.Model.SalesDetails;
import com.bootcamp.ApiStoreManagementII.Repository.SalesDetailsRepository;

@Service
public class SalesDetailsService {
	
	@Autowired
	private SalesDetailsRepository repository;
	
	public List<SalesDetails> getAll(){
		return repository.findAll();
	}
	
	public void save(SalesDetails saleDetail) {
		repository.save(saleDetail);
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
