package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.converter.BuildingDTOConverter;
import com.loinguyen1905.realestate.converter.BuildingSearchBuilderConverter;
import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.dto.BuildingRequestDTO;
import com.loinguyen1905.realestate.repository.BuildingRepository;
import com.loinguyen1905.realestate.repository.DistrictRepository;
import com.loinguyen1905.realestate.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private BuildingDTOConverter buildingDTOConverter;

    @Override
    public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode);
        List<BuildingEntity> raw = buildingRepository.findAll(buildingSearchBuilder);
        List<BuildingDTO> res = raw.stream().map(item -> buildingDTOConverter.toBuildingDTO(item)).toList();
        return res;
    }

    @Override
    public BuildingDTO findBuildingById(Long id) {
        Optional<BuildingEntity> building = buildingRepository.findById(id);
        try {
            return buildingDTOConverter.toBuildingDTO(building.get());
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteBuildingsByIds(List<Long> ids) {
        try {
            buildingRepository.deleteByIdIn(ids);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public BuildingDTO createBuilding(BuildingRequestDTO buildingRequestDTO) {
        BuildingEntity newBuilding = new BuildingEntity();
        newBuilding.setName(buildingRequestDTO.getName());
        newBuilding.setRentPriceDescription(buildingRequestDTO.getRentPriceDescription());
        newBuilding.setStructure(buildingRequestDTO.getStructure());
        newBuilding.setWard(buildingRequestDTO.getWard());
        newBuilding.setStreet(buildingRequestDTO.getStreet());
        newBuilding.setNumberOfBasement(buildingRequestDTO.getNumberOfBasement());
        newBuilding.setFloorArea(buildingRequestDTO.getFloorArea());
        newBuilding.setDirection(buildingRequestDTO.getDirection());
        try {
            Optional<DistrictEntity> district = districtRepository.findById(buildingRequestDTO.getDistrictId());
            newBuilding.setDistrict(district.get());
        } catch (Exception e) {
            e.getStackTrace();
            newBuilding.setDistrict(null);
        }
        newBuilding = buildingRepository.save(newBuilding);
        return buildingDTOConverter.toBuildingDTO(newBuilding);
    }
}