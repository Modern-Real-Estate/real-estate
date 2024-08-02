package com.loinguyen1905.realestate.model.request;

import java.util.List;
import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.AbstractDTO;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BuildingSearchRequest extends AbstractDTO<BuildingSearchRequest> {
    private String name;
    private String floorArea;
    private String ward;
    private String street;
    private String numberOfBasement;
    private String direction;
    private String level;
    private String areaFrom;
    private String areaTo;
    private String rentPriceFrom;
    private String rentPriceTo;
    private String managerName;
    private String managerPhone;
    private List<String> typeCodes;
    private UUID staffId;
    private List<String> districtCodes;
}