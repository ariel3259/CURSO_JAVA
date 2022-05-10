package com.bootcamp.Templates.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Users;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
	public boolean existsByPhone(int phone);
	
	public boolean existsByDni(int dni);
	
	public Students findByDni(int dni);
	
	@Query(value = "SELECT * FROM students s WHERE s.state = true", nativeQuery=true)
	public List<Students> findAll();

	public Page<Students> findAll(Pageable length);
	
	public Page<Students> findByNameContaining(String name, Pageable length);
	
	public Page<Students> findByLastNameContaining(String lastName, Pageable length);
	
	//order values: 
	//	asc = accendente
	//	desc = descendant
	@Query( value = "SELECT * FROM students s WHERE by s.name :order", countQuery = "SELECT count(*) FROM students", nativeQuery=true)
	public Page<Students> findByOrder(@Param("order") String order, Pageable length);
	
	@Query( value = "SELECT * FROM students s WHERE s.state = true ORDER BY s.last_name asc", nativeQuery=true)
	public List<Students> findByOrderAsc();
	
	@Modifying
	@Query(value = "UPDATE students s SET s.state = false WHERE s.id = :id", nativeQuery=true)
	public void deleteById(@Param("id") int id);
}
