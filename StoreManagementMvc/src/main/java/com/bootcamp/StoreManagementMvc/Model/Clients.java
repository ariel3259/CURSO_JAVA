package com.bootcamp.StoreManagementMvc.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
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
		name="clients",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "dni"),
				@UniqueConstraint(columnNames = "email")
		}
)
public class Clients {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Incompletes name")
	private String name;
	
	@NotBlank(message = "Incomplete last name")
	private String lastName;
	
	@NotBlank(message = "Incomplete Address")
	@Column(name = "address", columnDefinition = "TEXT NOT NULL")
	private String address;
	
	@NotNull(message = "Incomplete dni")
	private Integer dni;
	
	@NotBlank(message = "Incomplete email")
	@Email
	private String email;
	private String image;
}
