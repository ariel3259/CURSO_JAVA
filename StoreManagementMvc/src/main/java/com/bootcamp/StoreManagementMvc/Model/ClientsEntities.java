package com.bootcamp.StoreManagementMvc.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		name="clients",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "dni"),
				@UniqueConstraint(columnNames = "email")
		}
)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClientsEntities extends Clients {
	private int id;
	private int dni;
	private String email;
}
