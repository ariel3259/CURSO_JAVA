package com.bootcamp.VentaDeAutos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cars {
	private int id;
	private String brand;
	private String model;
	private double price;
}
