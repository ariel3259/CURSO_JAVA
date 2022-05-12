package com.bootcamp.Articles.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
				@UniqueConstraint(columnNames = {"username"})
		}
)
public class Users {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	@OneToOne
	private Role roles;
	
	public Users(String u, String p) {
		username = u;
		password = p;
	}
} 
