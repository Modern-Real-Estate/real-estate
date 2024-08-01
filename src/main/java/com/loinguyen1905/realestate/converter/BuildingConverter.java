package com.loinguyen1905.realestate.converter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.entity.PermissionEntity;
import com.loinguyen1905.realestate.entity.RentAreaEntity;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.request.BuildingRequest;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.model.request.PermissionSearchRequest;
import com.loinguyen1905.realestate.repository.specification.CustomSpecification;
import com.loinguyen1905.realestate.util.OverwriteUtils;
import com.loinguyen1905.realestate.util.StringUtils;

@Component
public class BuildingConverter {
  @Autowired
  private ModelMapper modelMapper;

  public Specification<BuildingEntity> toPermissionSpec(BuildingSearchRequest buildingSearchRequest) {
        Field[] fields = buildingSearchRequest.getClass().getDeclaredFields();
        List<Specification<BuildingEntity>> specList = new ArrayList<>();
        Arrays.asList(fields).forEach(field -> {
            try {
                String fieldName = StringUtils.convertCamelToSnake(field.getName());
                field.setAccessible(true);
                Object value = field.get(buildingSearchRequest);
                if(value == null) return;
                if(fieldName.endsWith("From"))
                    specList.add(CustomSpecification.isGreaterThanOrEqual((Integer) value, fieldName.substring(0, fieldName.length() - 4), null));
                else if(fieldName.endsWith("To"))
                    specList.add(CustomSpecification.isLessThanOrEqual((Integer) value, fieldName.substring(0, fieldName.length() - 2), null));
                else if(value.getClass().getName().equals("java.lang.String"))
                    specList.add(CustomSpecification.isValueLike((String) value, fieldName, null));
                else if(value instanceof Number)
                    specList.add(CustomSpecification.isEqualValue((Integer) value, fieldName, null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return Specification.allOf(specList);
    }

  public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity) {
    BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
    buildingDTO.setAddress(
        buildingEntity.getWard() + ", " +
            buildingEntity.getStreet() + " street, " +
            (buildingEntity.getDistrict() != null ? (buildingEntity.getDistrict().getName() + " district, ")
                : "Unknown district, ")
            +
            (buildingEntity.getDistrict() != null && buildingEntity.getDistrict().getCity() != null
                ? (buildingEntity.getDistrict().getCity().getName() + " city")
                : "Unknown city"));
    return buildingDTO;
  }

  public BuildingEntity toBuildingEntity(BuildingRequest buildingRequest) {
    BuildingEntity buildingEntity = modelMapper.map(buildingRequest, BuildingEntity.class);
    if (buildingRequest.getRentArea() != null) {
      List<RentAreaEntity> rentAreas = buildingRequest.getRentArea().stream().map(item -> {
        RentAreaEntity rentAreaEntity = new RentAreaEntity();
        rentAreaEntity.setValue(item);
        return rentAreaEntity;
      }).toList();
      buildingEntity.setRentArea(rentAreas);
    }
    return buildingEntity;
  }

  public BuildingEntity updateBuildingEntity(BuildingRequest newBuildingData, BuildingEntity modefiedBuilding) {
    modefiedBuilding = OverwriteUtils.overwrireObject(newBuildingData, modefiedBuilding);
    return modefiedBuilding;
  }
}