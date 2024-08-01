package com.loinguyen1905.realestate.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    void deleteByIdIn(List<UUID> ids);
    Optional<RoleEntity> findByCode(String code);
}