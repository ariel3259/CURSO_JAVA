package com.bootcamp.ApiReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiReservas.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByRole(String roles);
}
