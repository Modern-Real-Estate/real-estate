package com.loinguyen1905.realestate.repository.custom;

import java.util.List;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;

public interface BuildingRepositoryCustom {
    public List<BuildingEntity> findAll(BuildingSearchRequest buildingSearchRequest);
}