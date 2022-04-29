package com.bootcamp.StoreManagementMvc.Model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		name="clients",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "dni"),
				@UniqueConstraint(columnNames = "email")
		}
)
public class Clients {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String lastName;
	private int dni;
	private String email;
	private String address;
}
