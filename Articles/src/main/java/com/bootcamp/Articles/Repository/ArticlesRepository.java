package com.bootcamp.Articles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.Articles.Model.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {
	public boolean existsByCode(int code);
}
