package com.bootcamp.ApiStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.ApiStudentManagement.Model.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer>{
	public boolean existsByPhone(int phone);
	public boolean existsByDni(int dni);
}
