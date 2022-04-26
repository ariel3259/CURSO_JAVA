package com.bootcamp.ApiCrud.Repository;

import com.bootcamp.ApiCrud.Entity.ArmChairEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmChairRepository extends CrudRepository<ArmChairEntity, Integer> {
    public boolean existsByCode(int code);
}
