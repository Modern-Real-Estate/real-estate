package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.RentAreaEntity;
import com.loinguyen1905.realestate.model.dto.RentAreaDTO;
import com.loinguyen1905.realestate.repository.RentAreaRepository;
import com.loinguyen1905.realestate.service.IRentAreaService;

@Service
public class RentAreaService implements IRentAreaService {
    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RentAreaDTO> handleGetRentAreaByIds(List<UUID> ids) {
        List<RentAreaEntity> rentAreas = rentAreaRepository.findAllById(ids);
        return rentAreas.stream().map(item -> modelMapper.map(item, RentAreaDTO.class)).toList();
    }

    @Override
    public RentAreaDTO handleAddRentArea(RentAreaDTO rentAreaDTO) {
        RentAreaEntity rentarea = rentAreaRepository.save(modelMapper.map(rentAreaDTO, RentAreaEntity.class));
        return modelMapper.map(rentarea, RentAreaDTO.class);
    }
}