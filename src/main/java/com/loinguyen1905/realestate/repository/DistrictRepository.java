package com.loinguyen1905.realestate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.DistrictEntity;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, UUID> {}