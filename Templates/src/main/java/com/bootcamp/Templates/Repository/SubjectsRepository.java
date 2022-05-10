package com.bootcamp.Templates.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.Templates.Model.Subjects;
import com.bootcamp.Templates.Model.Users;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	public boolean existsByCode(int code);
	
	public Subjects findByCode(int code);
	
	@Query(value = "SELECT * FROM subjects s WHERE s.state = true", nativeQuery=true)
	public List<Subjects> findAll();
	
	public Page<Subjects> findByName(String name, Pageable length);
	
	//order values: 
	//	asc = accendente
	//	desc = descendant
	@Query( value = "SELECT * FROM users WHERE users u by u.name :order", countQuery = "SELECT count(*) FROM users", nativeQuery=true)
	public Page<Users> findByOrder(@Param("order") String order, Pageable length);
		
	
	@Modifying
	@Query(value = "UPDATE subjects s SET s.state = false WHERE s.id = :id ;", nativeQuery=true)
	public void deleteById(@Param("id") int id);
}
