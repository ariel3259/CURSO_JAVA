package com.ariel.MvcSpootify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariel.MvcSpootify.Model.PlayList;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

}
