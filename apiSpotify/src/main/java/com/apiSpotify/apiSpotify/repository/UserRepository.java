package com.apiSpotify.apiSpotify.repository;

import com.apiSpotify.apiSpotify.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository  extends JpaRepository<Usuario, Integer> {
    public boolean existsByUsername(String username);
public Usuario findByUsername(String username)

}