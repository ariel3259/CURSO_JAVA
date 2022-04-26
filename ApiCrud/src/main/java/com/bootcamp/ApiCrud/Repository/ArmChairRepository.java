package com.bootcamp.ApiCrud.Repository;

import com.bootcamp.ApiCrud.Entity.ArmChairEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmChairRepository extends CrudRepository<ArmChairEntity, Integer> {
    public boolean existsByCode(int code);

    public Optional<ArmChairEntity> findByCode(int code);
}
