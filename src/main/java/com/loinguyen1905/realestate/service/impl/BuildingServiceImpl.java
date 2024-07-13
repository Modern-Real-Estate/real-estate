package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.converter.BuildingSearchBuilderConverter;
import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.repository.BuildingRepository;
import com.loinguyen1905.realestate.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    public BuildingDTO mapperTool(BuildingEntity buildingEntity){
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);  
        buildingDTO.setDistrict(
            buildingEntity.getWard() + ", " + 
            buildingEntity.getStreet() + ", " + 
            buildingEntity.getDistrict().getName() + ", " +
            buildingEntity.getDistrict().getCity().getName()
        );
        return buildingDTO;
    }

    @Override
    public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode);
        List<BuildingEntity> raw = buildingRepository.findAll(buildingSearchBuilder);
        List<BuildingDTO> res = raw.stream().map(item -> mapperTool(item)).toList();
        return res;
    }
    
}