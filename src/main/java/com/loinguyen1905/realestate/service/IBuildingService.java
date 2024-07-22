package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.Map;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.dto.BuildingRequestDTO;

public interface IBuildingService {
    List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
    BuildingDTO findBuildingById(Long id);
    Boolean deleteBuildingsByIds(List<Long> ids);
    BuildingDTO addBuilding(BuildingRequestDTO buildingRequestDTO);

    // void updateOraddBuilding(BuildingDTO buildingDTO);
    // void deleteBuildings(List<Long> ids);
    // ResponseDTO loadStaffs(Long buildingId);
    // void updateAssignment(AssignmentDTO assignmentBuildingDTO);
    // int countTotalItems(BuildingSearchRequest buildingSearchRequest, Pageable pageable);
}