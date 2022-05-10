package com.bootcamp.Templates.Repository;


import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.Templates.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	@Query(value = "SELECT * FROM users u WHERE u.state = true", nativeQuery=true)
	public List<Users> findAll();
	
	public Page<Users> findAll(Pageable length);
	
	@Modifying
	@Query(value = "UPDATE users u SET u.state = false WHERE u.id = :id", nativeQuery=true)
	public void deleteById(@Param("id") int id);
	
	public boolean existsByUsername(String username);
}
