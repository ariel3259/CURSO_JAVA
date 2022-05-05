package com.bootcamp.ApiUsers.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"phone"}),
				@UniqueConstraint(columnNames = {"dni"})
		}
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String lastName;
	private int phone;
	private int dni;
}
