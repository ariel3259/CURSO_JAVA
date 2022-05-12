package com.bootcamp.ApiStoreManagementII.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiStoreManagementII.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	public boolean existsByEmail(String email);
	public Users findByEmail(String email);
}
