package com.loinguyen1905.realestate.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.util.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = BuildingSearchBuilder.builder()
                .name(MapUtil.getObject(params, "name", String.class))
                .floorArea(MapUtil.getObject(params, "floorArea", Integer.class))
                .numberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
                .ward(MapUtil.getObject(params, "ward", String.class))
                .district(MapUtil.getObject(params, "district", String.class))
                .street(MapUtil.getObject(params, "street", String.class))
                .managerName(MapUtil.getObject(params, "managerName", String.class))
                .managerPhoneNumber(MapUtil.getObject(params, "managerPhoneNumber", String.class))
                .direction(MapUtil.getObject(params, "direction", String.class))
                .level(MapUtil.getObject(params, "level", String.class))
                .rentPriceFrom(MapUtil.getObject(params, "rentPriceFrom", Integer.class))
                .rentPriceTo(MapUtil.getObject(params, "rentPriceTo", Integer.class))
                .areaFrom(MapUtil.getObject(params, "areaFrom", Integer.class))
                .areaTo(MapUtil.getObject(params, "areaTo", Integer.class))
                .staffId(MapUtil.getObject(params, "staffId", Integer.class))
                .typeCode(typeCode)
                .build();
        return buildingSearchBuilder;
    }
}