package com.bootcamp.ApiReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiReservas.Model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}
