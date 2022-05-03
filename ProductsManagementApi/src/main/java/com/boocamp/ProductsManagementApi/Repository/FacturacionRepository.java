package com.boocamp.ProductsManagementApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boocamp.ProductsManagementApi.Model.Facturacion;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Long> {
	
	@Query(value = "SELECT * FROM facturacion f WHERE f.state=true", nativeQuery=true)
	public List<Facturacion> findAll();
	
	@Modifying
	@Query(value = "UPDATE facturacion f SET f.state=FALSE WHERE f.id=:id", nativeQuery=true)
	public void deleteById(@Param("id") Long id);
	
	@Query(
			value = "SELECT SUMA(p.price) FROM products p INNER JOIN facturacion f ON p.id = f.id_products WHERE f.id_client = :idClient",
			nativeQuery=true)
	public int getTotalFacturacion(@Param("idClient") Long idClient);
}
