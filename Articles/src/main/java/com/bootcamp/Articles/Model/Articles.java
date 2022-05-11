package com.bootcamp.Articles.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Articles {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int stock, code;
	private double price;
	private String name;
}
