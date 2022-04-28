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
		name = "subjects",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "code")
		}
)
public class Subjects {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int code;
	private String name;
}
