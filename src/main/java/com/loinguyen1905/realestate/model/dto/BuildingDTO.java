package com.loinguyen1905.realestate.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter; 

@Getter
@Setter
// @EqualsAndHashCode(callSuper = true)
@SuppressWarnings("rawtypes")
public class BuildingDTO extends AbstractDTO {
    private String name;
    private String district;
    private String ward;
    private String street;
    private String structure;
    private String Address;
    private Long numberOfBasement;
    private Long floorArea;
    private String direction;
    private String level;
    private String rentArea;
    private Integer rentPrice;
    private String rentPriceDescription;
    private String serviceFee;
    private String carFee;
    private String motoFee;
    private String overtimeFee;
    private String electricityFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationtime;
    private String managerName;
    private String managerPhone;
    private Integer brokerageFee;
    private String note;
    private List<String> typeCode;
    private String avatar;
    private String imageBase64;
    private String imageName;
}