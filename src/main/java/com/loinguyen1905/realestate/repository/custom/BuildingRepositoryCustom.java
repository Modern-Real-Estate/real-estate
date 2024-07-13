package com.loinguyen1905.realestate.repository.custom;

import java.util.List;


import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}