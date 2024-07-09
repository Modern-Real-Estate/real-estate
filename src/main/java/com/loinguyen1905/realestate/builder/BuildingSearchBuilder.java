package com.loinguyen1905.realestate.builder;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BuildingSearchBuilder {
    private String name;
    private Integer floorArea;
    private Integer numberOfBasement;
    private String district;
    private String ward;
    private String street;
    private String managerName;
    private String managerPhoneNumber;
    private String direction;
    private String level;
    @Builder.Default
    private List<String> typeCode = new ArrayList<String>();
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private Integer areaFrom;
    private Integer areaTo;
    private Integer staffId;
}
