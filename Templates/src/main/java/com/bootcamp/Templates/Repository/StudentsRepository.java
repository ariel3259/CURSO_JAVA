package com.bootcamp.Templates.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.Templates.Model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
	public boolean existsByPhone(int phone);
	public boolean existsByDni(int dni);
	public Students findByDni(int dni);
}
