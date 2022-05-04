package com.bootcamp.Templates.Requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
	@NotNull(message = "Incomplete code")
	private int codeSubject;
	
	@NotNull(message = "Incomplete dni")
	private int dniStudent;
}
