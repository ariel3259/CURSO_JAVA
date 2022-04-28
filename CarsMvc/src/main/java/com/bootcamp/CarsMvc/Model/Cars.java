package com.bootcamp.CarsMvc.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Cars {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	private String model;
	private String brand;
	private int doors;
	private String color;
	private double kilometer;
}
