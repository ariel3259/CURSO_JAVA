package com.bootcamp.ApiStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bootcamp.ApiStudentManagement.Model.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer>{
	public boolean existsByPhone(int phone);
	public boolean existsByDni(int dni);

	@Modifying
	@Query( value = "UPDATE `students` s SET s.name = :name WHERE s.id = :id")
	public void modifyName(@Param("name") String name, @Param("id") int id);
	
	@Modifying
	@Query(value="UPDATE `students` s SET s.username= :username WHERE s.id = :id")
	public void modifyUsername(@Param("username") String username, @Param("id") int id);
}
