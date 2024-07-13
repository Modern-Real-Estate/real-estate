package com.loinguyen1905.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.repository.custom.BuildingRepositoryCustom;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {}