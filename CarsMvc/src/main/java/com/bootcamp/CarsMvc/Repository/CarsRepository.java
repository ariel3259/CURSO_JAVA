package com.bootcamp.CarsMvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.CarsMvc.Model.Cars;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {

}
