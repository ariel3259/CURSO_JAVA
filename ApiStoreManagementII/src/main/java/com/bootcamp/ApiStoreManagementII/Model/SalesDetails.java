package com.bootcamp.ApiStoreManagementII.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_details")
public class SalesDetails {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	private List<Sales> sale;
	@OneToMany
	private List<Products> product;
	
	@NotNull
	private int items;
}
