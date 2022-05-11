package com.bootcamp.ApiStoreManagementII.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.ApiStoreManagementII.Model.SalesDetails;

@Repository
public interface SalesDetailsRepository extends JpaRepository<SalesDetails, Long> {
}
