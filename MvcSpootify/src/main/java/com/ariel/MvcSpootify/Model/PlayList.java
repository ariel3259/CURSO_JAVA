package com.ariel.MvcSpootify.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlist")
public class PlayList {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Songs song;
	
}
