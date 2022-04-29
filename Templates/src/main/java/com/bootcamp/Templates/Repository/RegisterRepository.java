package com.bootcamp.Templates.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.Templates.Model.Register;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Subjects;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
	public boolean existsBySubject(Subjects subject);
	public boolean existsByStudent(Students student);
}
