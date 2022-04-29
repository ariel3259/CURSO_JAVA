package com.bootcamp.Templates.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.Templates.Model.Subjects;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	public boolean existsByCode(int code);
	public Subjects findByCode(int code);
}
