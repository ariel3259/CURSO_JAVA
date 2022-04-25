package com.bootcamp.ApiStore.Repositories;

import com.bootcamp.ApiStore.Model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer> {
    public boolean existsByCode(int code);
}
