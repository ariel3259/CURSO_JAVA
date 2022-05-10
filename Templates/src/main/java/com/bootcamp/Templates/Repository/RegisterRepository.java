package com.bootcamp.Templates.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.Templates.Model.Register;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Subjects;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
	public boolean existsBySubject(Subjects subject);
	public boolean existsByStudent(Students student);
	
	@Query(value = "SELECT * FROM registration r WHERE r.state = true", nativeQuery=true)
	public List<Register> findAll();
	
	public Page<Register> findAll(Pageable pages);
	
	 @Query(
			 value = "SELECT * FROM registration r INNER JOIN subjects s ON r.subject_id = s.id WHERE s.name = :subjectName", 
			 countQuery = "SELECT count(*) FROM registration",
			 nativeQuery = true)
	public Page<Register> findBySubjectName(@Param("subjectName") String subjectName, Pageable page);
	

	 @Query(
			 value = "SELECT * FROM registration r INNER JOIN subjects s ON r.subject_id = s.id WHERE s.name = :subjectID", 
			 nativeQuery = true)
	public List<Register> findByStudentId(@Param("subjectID") int studentId);
	 
	 @Query(
			 value = "SELECT * FROM registration r INNER JOIN students s ON r.student_id = s.id WHERE s.name = :studentName", 
			 countQuery = "SELECT count(*) FROM registration",
			 nativeQuery = true)
	public Page<Register> findByStudentName(@Param("studentName") String studentName, Pageable page);
	 
	@Modifying
	@Query(value = "UPDATE registration r SET r.state = false WHERE r.student_id= :studentId ;", nativeQuery=true)
	public void deleteByStudentId(@Param("studentId") int studentId);
	
	@Modifying
	@Query(value =  "UPDATE registration  SET state = false WHERE subject_id = :subjectId ;", nativeQuery=true)
	public void deleteBySubjectId(@Param("subjectId") int subjectId);
	
	@Modifying
	@Query(value = "UPDATE registration r SET r.state = false WHERE r.id = :id", nativeQuery=true)
	public void deleteById(@Param("id") int id);
}
