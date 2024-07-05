package com.loinguyen1905.realestate.repository;

import java.util.List;

import com.loinguyen1905.realestate.entity.BuildingEntity;

public interface BuildingRepository {
    List<BuildingEntity> findAll();
}