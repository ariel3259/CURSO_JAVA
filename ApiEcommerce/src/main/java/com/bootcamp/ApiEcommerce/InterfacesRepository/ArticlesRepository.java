package com.bootcamp.ApiEcommerce.InterfacesRepository;

import com.bootcamp.ApiEcommerce.Model.Articles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends CrudRepository<Articles, Integer> {
}
