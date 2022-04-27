package com.bootcamp.ApiStudentManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(
		name = "students",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"dni"}),
				@UniqueConstraint(columnNames = {"phone"})
		}
)
public class Students {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private int phone;
	
	@NotBlank
	private int dni;
}
