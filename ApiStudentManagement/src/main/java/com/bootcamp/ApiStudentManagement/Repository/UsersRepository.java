package com.bootcamp.ApiStudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.ApiStudentManagement.Model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	public boolean existsByUsername(String username);
	
}
