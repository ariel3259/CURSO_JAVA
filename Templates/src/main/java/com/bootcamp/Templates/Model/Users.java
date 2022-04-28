package com.bootcamp.Templates.Model;

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
		name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"email"}),
				@UniqueConstraint(columnNames = {"username"})
		}
)
public class Users {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
}
