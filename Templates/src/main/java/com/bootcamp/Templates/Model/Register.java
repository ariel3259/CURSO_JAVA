package com.bootcamp.Templates.Model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		name="registration"
)
public class Register {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Subjects subject;
	
	@ManyToOne
	private Students student;
	
	public Register(Subjects su, Students stu) {
		this.subject = su;
		this.student = stu;
	}
}
