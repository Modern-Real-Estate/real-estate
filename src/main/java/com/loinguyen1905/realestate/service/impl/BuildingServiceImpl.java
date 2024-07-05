package com.loinguyen1905.realestate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.repository.BuildingRepository;
import com.loinguyen1905.realestate.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingEntity> raw = buildingRepository.findAll();
        List<BuildingDTO> res = new ArrayList<BuildingDTO>();
        for(BuildingEntity e : raw) {
            BuildingDTO buildingDTO = modelMapper.map(e, BuildingDTO.class);    
            res.add(buildingDTO);
        }
        return res;
    }
    
}