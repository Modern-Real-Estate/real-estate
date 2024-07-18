package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.Map;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.dto.BuildingRequestDTO;

public interface BuildingService {
    List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
    BuildingDTO findBuildingById(Long id);
    Boolean deleteBuildingsByIds(List<Long> ids);
    BuildingDTO createBuilding(BuildingRequestDTO buildingRequestDTO);
}