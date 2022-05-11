package com.bootcamp.ApiStoreManagementII.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"code"})
		}
)
public class Products {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private int code;
	private int stock;
	private String name;
}
