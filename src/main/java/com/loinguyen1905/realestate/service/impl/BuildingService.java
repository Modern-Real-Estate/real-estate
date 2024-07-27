package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.converter.BuildingConverter;
import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.dto.DistrictDTO;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.model.request.BuildingRequest;
import com.loinguyen1905.realestate.repository.BuildingRepository;
import com.loinguyen1905.realestate.service.IBuildingService;
import com.loinguyen1905.realestate.service.IDistrictService;
import com.loinguyen1905.realestate.util.OverwriteUtils;

@Service
public class BuildingService implements IBuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BuildingDTO> handleGetBuildings(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> buildings = buildingRepository.findAll(buildingSearchRequest);
        return buildings.stream().map(item -> buildingConverter.toBuildingDTO(item)).toList();
    }

    @Override
    public BuildingDTO handleGetBuildingById(UUID id) { 
        Optional<BuildingEntity> isExistBuilding = buildingRepository.findById(id);
        if(isExistBuilding.isPresent()) return buildingConverter.toBuildingDTO(isExistBuilding.get());
        return null;
    } 

    @Override
    public void handleDeleteBuildingByIds(List<UUID> ids) {
        buildingRepository.deleteByIdIn(ids);
    }
    
    @Override
    public BuildingDTO handleAddOrUpdateBuilding(BuildingRequest buildingRequest) {
        // General Operations
        BuildingEntity newData = buildingConverter.toBuildingEntity(buildingRequest);
        if(buildingRequest.getDistrictId() instanceof UUID id) {
            DistrictDTO districtDTO = districtService.handleFindDistrictById(id);
            if(districtDTO != null) newData.setDistrict(modelMapper.map(districtDTO, DistrictEntity.class));
        }
        
        if(buildingRequest.getId() instanceof UUID id) { // Update
            Optional<BuildingEntity> isExistBuilding = buildingRepository.findById(id);
            if(isExistBuilding.isPresent() && isExistBuilding.get() instanceof BuildingEntity beModifiedBuilding) {
                beModifiedBuilding = OverwriteUtils.overwrireObject(newData, beModifiedBuilding);
                newData = buildingRepository.save(beModifiedBuilding);
            }
        } else newData = buildingRepository.save(newData); // Create
        // Return
        return buildingConverter.toBuildingDTO(newData);
    }
}