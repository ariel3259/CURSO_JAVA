package com.bootcamp.ApiCrud.Repository;


import com.bootcamp.ApiCrud.Entity.FurnitureEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends CrudRepository<FurnitureEntity, Integer> {
    public boolean existsByCode(int code);

}
