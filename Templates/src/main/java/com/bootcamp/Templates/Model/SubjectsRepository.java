package com.bootcamp.Templates.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	public boolean existsByCode(int code);
	
	public Subjects findByCode(int code);
	
	@Query(value = "SELECT * FROM subjects s WHERE s.state = true", nativeQuery=true)
	public List<Subjects> findAll();
	
	@Modifying
	@Query(value = "UPDATE subjects s SET s.state = false WHERE s.id = :id ;", nativeQuery=true)
	public void deleteById(@Param("id") int id);
}
