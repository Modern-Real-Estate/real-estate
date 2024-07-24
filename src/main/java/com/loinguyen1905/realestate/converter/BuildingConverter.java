package com.loinguyen1905.realestate.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.entity.RentAreaEntity;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.request.BuildingRequest;

@Component
public class BuildingConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity){
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
        // buildingDTO.setAddress(
        //     buildingEntity.getWard() + ", " +
        //     buildingEntity.getStreet() + " street, " +
        //     (buildingEntity.getDistrict() != null ? (buildingEntity.getDistrict().getName() + ", ") : "") +
        //     (buildingEntity.getDistrict() != null && buildingEntity.getDistrict().getCity() != null ? (buildingEntity.getDistrict().getCity().getName() + " city") : "")
        // );
        // String rentAreaString = rentAreas.stream().map(item -> item.getValue().toString()).collect(Collectors.joining(", "));
        // buildingDTO.setRentArea(rentAreaString);
        return buildingDTO;
    }

    public <T> BuildingEntity toBuildingEntity(T object) {
        if(object instanceof BuildingRequest buildingRequest) {
            return modelMapper.map(buildingRequest, BuildingEntity.class);
        } else if(object instanceof BuildingDTO buildingDTO) {
            return modelMapper.map(buildingDTO, BuildingEntity.class);
        }
        return null;
    }
}
