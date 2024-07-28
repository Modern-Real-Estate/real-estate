package com.loinguyen1905.realestate.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findUserByUsername(String username);
}