package com.bootcamp.Templates.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
	public boolean existsByPhone(int phone);
	
	public boolean existsByDni(int dni);
	
	public Students findByDni(int dni);
	
	@Query(value = "SELECT * FROM students s WHERE s.state = true", nativeQuery=true)
	public List<Students> findAll();
	
	@Modifying
	@Query(value = "UPDATE students s SET s.state = false WHERE s.id = :id", nativeQuery=true)
	public void deleteById(@Param("id") int id);
}
