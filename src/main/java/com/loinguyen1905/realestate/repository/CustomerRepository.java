package com.loinguyen1905.realestate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID>{

    String findByEmailSQL = "select c.* from customer as c where email = ?1";
    @Query(value = findByEmailSQL, nativeQuery = true)
    CustomerEntity findByEmail(String username);

}