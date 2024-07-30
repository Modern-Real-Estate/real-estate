package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.naming.NameNotFoundException;

import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.exception.CustomException;
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
        DistrictEntity district = this.modelMapper.map(districtDTO, DistrictEntity.class);
        district = this.districtRepository.save(district);
        return this.modelMapper.map(district, DistrictDTO.class);
    }

    @Override
    public DistrictDTO handleGetDistrictById(UUID id) {
        DistrictEntity district = this.districtRepository.findById(id)
                .orElseThrow(() -> new CustomException("Not found district id " + id));
        return this.modelMapper.map(district, DistrictDTO.class);
    }

    @Override
    public List<DistrictDTO> handleGetAllDistrict() {
        List<DistrictEntity> districts = this.districtRepository.findAll();
        return districts.stream()
                .map(item -> this.modelMapper.map(item, DistrictDTO.class)).toList();
    }
}