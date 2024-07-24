package com.loinguyen1905.realestate.service.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.converter.BuildingConverter;
import com.loinguyen1905.realestate.converter.BuildingSearchBuilderConverter;
import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.exception.MyException;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.model.request.BuildingRequest;
import com.loinguyen1905.realestate.repository.BuildingRepository;
import com.loinguyen1905.realestate.repository.DistrictRepository;
import com.loinguyen1905.realestate.service.IBuildingService;
import com.loinguyen1905.realestate.util.OverwriteUtil;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private BuildingConverter buildingConverter;

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
    public Boolean handleDeleteBuildingByIds(List<UUID> ids) {
        try {
            buildingRepository.deleteByIdIn(ids);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public BuildingDTO handleAddBuilding(BuildingRequest buildingRequest) {
        BuildingEntity newBuilding = buildingConverter.toBuildingEntity(buildingRequest);
        // try {
        //     Optional<DistrictEntity> district = districtRepository.findById(buildingRequest.getDistrictId());
        //     newBuilding.setDistrict(district.get());
        // } catch (Exception e) {
        //     e.getStackTrace();
        //     newBuilding.setDistrict(null);
        // }
        newBuilding = buildingRepository.save(newBuilding);
        return buildingConverter.toBuildingDTO(newBuilding);
    }

    @Override
    public BuildingDTO handleUpdateBuilding(BuildingRequest buildingRequest) {
        Optional<BuildingEntity> isExistBuilding = buildingRepository.findById(buildingRequest.getId());
        if(isExistBuilding.get() instanceof BuildingEntity modifiedBuilding) {
            modifiedBuilding = OverwriteUtil.overwrireObject(buildingRequest, modifiedBuilding);
            modifiedBuilding = buildingRepository.save(modifiedBuilding);
            return buildingConverter.toBuildingDTO(modifiedBuilding);
        }
        return null;
    }   
}