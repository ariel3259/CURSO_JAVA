package com.bootcamp.ApiStoreManagementII.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_details")
public class SalesDetails {
	private long id;
	@OneToOne
	private Sales sale;
	@OneToMany
	private Products product;
	private int items;
}
