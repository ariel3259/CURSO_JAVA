package com.bootcamp.Articles.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.Articles.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByName(String name);
}
