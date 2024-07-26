package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.model.dto.DistrictDTO;
import com.loinguyen1905.realestate.repository.DistrictRepository;
import com.loinguyen1905.realestate.service.IDistrictService;

@Service
public class DistrictService implements IDistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DistrictDTO handleAddDistrict(DistrictDTO districtDTO) {
        DistrictEntity districtEntity = modelMapper.map(districtDTO, DistrictEntity.class);
        districtEntity = districtRepository.save(districtEntity);
        return modelMapper.map(districtEntity, DistrictDTO.class);
    }

    @Override
    public DistrictDTO handleFindDistrictById(UUID id) {
        Optional<DistrictEntity> district = districtRepository.findById(id);
        if(district.isPresent()) return modelMapper.map(district, DistrictDTO.class);
        return null;
    }

    @Override
    public List<DistrictDTO> handleGetAllDistrict() {
        List<DistrictEntity> districts = districtRepository.findAll();
        return districts
                .stream()
                .map(item -> modelMapper.map(item, DistrictDTO.class)).toList();
    }   
}