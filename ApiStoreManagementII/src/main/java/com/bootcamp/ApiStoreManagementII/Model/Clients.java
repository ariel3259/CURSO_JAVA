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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"dni"})
		}
)
public class Clients {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int dni;
	private String name;
	private String lastName;
}
