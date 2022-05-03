package com.boocamp.ProductsManagementApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boocamp.ProductsManagementApi.Model.Facturacion;
import com.boocamp.ProductsManagementApi.Repository.FacturacionRepository;

@Service
public class FacturacionService {
	
	@Autowired
	private FacturacionRepository facturacionRepository;
	
	public List<Facturacion> getAll(){
		return facturacionRepository.findAll();
	}
	
	public void save(Facturacion factura) {
		facturacionRepository.save(factura);
	}
	
	public void update(Facturacion factura) {
		facturacionRepository.save(factura);
	}
	
	public void delete(Long id) {
		facturacionRepository.deleteById(id);
	}
	
	public int getTotal(Long idClient) {
		return facturacionRepository.getTotalFacturacion(idClient);
	}
}
