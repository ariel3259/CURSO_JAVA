package com.boocamp.ProductsManagementApi.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturacion")
public class Facturacion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Clients client;
	
	@ManyToOne
	private List<Products> product;
	private boolean state;
}
