package com.loinguyen1905.realestate.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.utils.MapUtils;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = BuildingSearchBuilder.builder()
                .name(MapUtils.getObject(params, "name", String.class))
                .floorArea(MapUtils.getObject(params, "floorArea", Integer.class))
                .numberOfBasement(MapUtils.getObject(params, "numberOfBasement", Integer.class))
                .ward(MapUtils.getObject(params, "ward", String.class))
                .district(MapUtils.getObject(params, "district", String.class))
                .street(MapUtils.getObject(params, "street", String.class))
                .managerName(MapUtils.getObject(params, "managerName", String.class))
                .managerPhoneNumber(MapUtils.getObject(params, "managerPhoneNumber", String.class))
                .direction(MapUtils.getObject(params, "direction", String.class))
                .level(MapUtils.getObject(params, "level", String.class))
                .rentPriceFrom(MapUtils.getObject(params, "rentPriceFrom", Integer.class))
                .rentPriceTo(MapUtils.getObject(params, "rentPriceTo", Integer.class))
                .areaFrom(MapUtils.getObject(params, "areaFrom", Integer.class))
                .areaTo(MapUtils.getObject(params, "areaTo", Integer.class))
                .staffId(MapUtils.getObject(params, "staffId", Integer.class))
                .typeCode(typeCode)
                .build();
        return buildingSearchBuilder;
    }
}