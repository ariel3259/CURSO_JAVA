package com.bootcamp.ApiReservas.Model;

import java.sql.Date;

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
public class Reserva {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date starts;
	private Date ends;
	private int numberRoom;
}
