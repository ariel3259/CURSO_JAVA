package com.bootcamp.MvcUsers.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private long id;
	
	@NotBlank(message = "Incomplete name")
	private String name;
	
	@NotBlank(message = "Incomplete lastName")
	private String lastName;
	
	@NotNull(message = "Incomplete phone")
	private int phone;
	
	@NotNull(message = "Incomplete dni")
	private int dni;
}
