package com.bootcamp.Templates.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		name = "students",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"phone"}),
				@UniqueConstraint(columnNames = {"dni"})
		}
)
public class Students {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Incomplete name")
	private String name;
	
	@NotBlank(message = "Incomplete last name")
	private String lastName;
	
	@NotNull(message = "Incomplete phone")
	private int phone;
	
	@NotNull(message = "Incomplete dni")
	private int dni;
	
	private boolean state;
}
