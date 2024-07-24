package com.loinguyen1905.realestate.model.request;

import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.AbstractDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingRequest extends AbstractDTO<BuildingRequest> {
    private String name;
    private String rentPriceDescription;
    private String structure;
    private String ward;
    private String street;
    private String numberOfBasement;
    private String floorArea;
    private String direction;
    private String level;
    // private String rentArea;
    private String rentPrice;
    private String managerName;
    private String managerPhone;
    // private String serviceFee;
    // private String carFee;
    // private String motoFee;
    // private String overtimeFee;
    // private String electricityFee;
    // private String deposit;
    // private String payment;
    // private String rentTime;
    // private String decorationtime;
    // private String avatar;
    // private String imageBase64;
    // private String imageName;
    // private String brokerageFee;
    // private String note;

    // private List<String> typeCode;
    // private UUID districtId;
}