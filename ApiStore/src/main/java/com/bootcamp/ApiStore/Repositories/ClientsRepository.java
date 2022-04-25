package com.bootcamp.ApiStore.Repositories;

import com.bootcamp.ApiStore.Model.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Clients, Integer> {
    public boolean existsByDni(int dni);
}
