package com.loinguyen1905.realestate.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.repository.custom.BuildingRepositoryCustom;

import jakarta.transaction.Transactional;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, UUID>, BuildingRepositoryCustom {
    @Transactional
    void deleteByIdIn(List<UUID> ids);
}