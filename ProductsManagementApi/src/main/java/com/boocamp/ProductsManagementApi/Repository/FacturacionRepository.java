package com.boocamp.ProductsManagementApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boocamp.ProductsManagementApi.Model.Facturacion;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Long> {
	
	@Query(value = "SELECT f FROM `facturacion` f WHERE f.state=TRUE")
	public List<Facturacion> findAll();
	
	@Query(value = "UPDATE `facturacion` f SET f.state=FALSE WHERE f.id=:id")
	public void deleteById(@Param("id") Long id);
	
	@Query(value = "SELECT SUMA(p.price) FROM `products` p INNER JOIN `facturacion` f ON p.id = f.id_products WHERE f.id_client = :idClient")
	public int getTotalFacturacion(@Param("idClient") Long idClient);
}
