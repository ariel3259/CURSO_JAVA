package com.bootcamp.ApiStore.Repositories;

import com.bootcamp.ApiStore.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    public boolean existsByEmail(String email);
    public Optional<Users> findUserByEmail(String email);
}
