package com.loinguyen1905.realestate.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    String findByEmailSQL = "select u.* from user as u where u.username = ?1";
    @Query(value = findByEmailSQL, nativeQuery = true)
    Optional<UserEntity> findUserByUsername(String username);
}