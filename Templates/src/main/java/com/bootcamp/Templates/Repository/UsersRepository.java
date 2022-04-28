package com.bootcamp.Templates.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.Templates.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	public boolean existsByUsername(String username);
}
