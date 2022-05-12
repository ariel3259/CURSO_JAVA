package com.bootcamp.Articles.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.Articles.Model.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long> {
	public boolean existsByCode(int code);
	public Articles findByCode(int code);
	public List<Articles> findByName(String name);
	public List<Articles> findByPrice(double price);
	public List<Articles> findByStock(int stock);
}
