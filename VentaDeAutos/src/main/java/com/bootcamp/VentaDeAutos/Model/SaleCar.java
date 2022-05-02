package com.bootcamp.VentaDeAutos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleCar {
	private int ticket;
	private String name;
	private Cars car;
}
