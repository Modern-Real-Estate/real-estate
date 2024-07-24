package com.loinguyen1905.realestate.model.dto;

import lombok.Getter;
import lombok.Setter; 

@Getter
@Setter
public class BuildingDTO extends AbstractDTO<BuildingDTO> {
    private String name;
    private String rentPriceDescription;
    private String structure;
    private String address;
    private String numberOfBasement;
    private String floorArea;
    private String direction;
    private String level;
    private String rentArea;
    private String rentPrice;
    // private String serviceFee;
    // private String carFee;
    // private String motoFee;
    // private String overtimeFee;
    // private String electricityFee;
    // private String deposit;
    // private String payment;
    // private String rentTime;
    // private String decorationtime;
    private String managerName;
    private String managerPhone;
    // private Integer brokerageFee;
    // private String note;
    // private List<String> typeCode;
    // private String avatar;
    // private String imageBase64;
    // private String imageName;
}