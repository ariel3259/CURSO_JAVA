package com.ariel.MvcSpootify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariel.MvcSpootify.Model.Songs;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Integer> {

}
