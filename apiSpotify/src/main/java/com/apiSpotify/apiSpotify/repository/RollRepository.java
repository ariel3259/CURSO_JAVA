package com.apiSpotify.apiSpotify.repository;

import com.apiSpotify.apiSpotify.model.Roll;
import com.apiSpotify.apiSpotify.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RollRepository  extends JpaRepository<Roll, Integer> {
    public boolean existsByName(String name);
    public Roll findByName(String name);
}