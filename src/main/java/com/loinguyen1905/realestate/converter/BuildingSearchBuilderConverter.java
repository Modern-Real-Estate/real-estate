package com.loinguyen1905.realestate.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.util.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
    // public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest) {
    //     BuildingSearchBuilder buildingSearchBuilder = BuildingSearchBuilder.builder()
    //             .name(buildingSearchRequest.getName())
    //             // .floorArea(buildingSearchRequest.getFloorArea())
    //             .ward(buildingSearchRequest.getWard())
    //             .street(buildingSearchRequest.getStreet())
    //             .district(buildingSearchRequest.getDistrict())
    //             .numberOfBasement(buildingSearchRequest.getNumberOfBasement())
    //             .typeCode(buildingSearchRequest.getTypeCode())
    //             .managerName(buildingSearchRequest.getManagerName())
    //             .managerPhone(buildingSearchRequest.getManagerPhone())
    //             .rentPriceTo(buildingSearchRequest.getRentPriceTo())
    //             .rentPriceFrom(buildingSearchRequest.getRentPriceFrom())
    //             .areaTo(buildingSearchRequest.getAreaTo())
    //             .areaFrom(buildingSearchRequest.getAreaFrom())
    //             .staffId(buildingSearchRequest.getStaffId())
    //             .build();
    //     return buildingSearchBuilder;
    // }
}