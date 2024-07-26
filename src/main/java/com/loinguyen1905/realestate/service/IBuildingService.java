package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.model.request.BuildingRequest;

public interface IBuildingService {
    List<BuildingDTO> handleGetBuildings(BuildingSearchRequest buildingSearchRequest);
    BuildingDTO handleGetBuildingById(UUID id);
    Boolean handleDeleteBuildingByIds(List<UUID> ids);
    BuildingDTO handleAddOrUpdateBuilding(BuildingRequest buildingRequestDTO);
    
    // void updateOraddBuilding(BuildingDTO buildingDTO);
    // void deleteBuildings(List<Long> ids);
    // ResponseDTO loadStaffs(Long buildingId);
    // void updateAssignment(AssignmentDTO assignmentBuildingDTO);
    // int countTotalItems(BuildingSearchRequest buildingSearchRequest, Pageable pageable);
}