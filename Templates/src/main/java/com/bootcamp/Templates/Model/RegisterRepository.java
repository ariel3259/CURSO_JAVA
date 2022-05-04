package com.bootcamp.Templates.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
	public boolean existsBySubject(Subjects subject);
	public boolean existsByStudent(Students student);
	
	@Query(value = "SELECT * FROM registration r WHERE r.state = true", nativeQuery=true)
	public List<Register> findAll();
	
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
