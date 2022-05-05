package com.bootcamp.ApiGames.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Games {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private String gender;
	private String publisher;
	private String studio;
	private double price;
	
	public boolean isEmpty() {
		return this.getName().isEmpty() || 
				this.getDescription().isEmpty() || 
				this.getGender().isEmpty() || 
				this.getStudio().isEmpty() || 
				this.getPublisher().isEmpty() ||
				this.getPrice() == 0;
	}
}
