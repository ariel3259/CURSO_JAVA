package com.ariel.MvcSpootify.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Songs {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int time;
	private String name;
	private String brandName;
	private String gender;
}
