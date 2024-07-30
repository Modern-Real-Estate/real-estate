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
import com.loinguyen1905.realestate.exception.CustomRuntimeException;
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
        List<BuildingEntity> buildings = this.buildingRepository.findAll(buildingSearchRequest);
        return buildings.stream().map(item -> this.buildingConverter.toBuildingDTO(item)).toList();
    }

    @Override
    public BuildingDTO handleGetBuildingById(UUID id) {
        BuildingEntity building = this.buildingRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Not found buidling with id " + id));
        return this.buildingConverter.toBuildingDTO(building);
    }

    @Override
    public void handleDeleteBuildingByIds(List<UUID> ids) {
        this.buildingRepository.deleteByIdIn(ids);
    }

    @Override
    public BuildingDTO handleAddOrUpdateBuilding(BuildingRequest buildingRequest) {
        BuildingEntity newData = this.buildingConverter.toBuildingEntity(buildingRequest); // To building
        if (buildingRequest.getDistrictId() instanceof UUID id) // Set district in both case
            newData.setDistrict(this.modelMapper.map(this.districtService.handleGetDistrictById(id), DistrictEntity.class));
        if (buildingRequest.getId() instanceof UUID id) { // Update
            BuildingEntity beModifiedBuilding = this.buildingRepository.findById(id).orElseThrow(null);
            beModifiedBuilding = OverwriteUtils.overwrireObject(newData, beModifiedBuilding);
            newData = this.buildingRepository.save(beModifiedBuilding);
        } else
            newData = this.buildingRepository.save(newData); // Create
        return this.buildingConverter.toBuildingDTO(newData);
    }
}