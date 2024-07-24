package com.loinguyen1905.realestate.entity;

import lombok.*;

import java.util.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntityAudit {
    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "structure")
    private String structure;

    @Column(name = "number_of_basement")
    private String numberOfBasement;

    @Column(name = "floor_area")
    private String floorArea;

    @Column(name = "direction")
    private String direction;

    @Column(name = "level")
    private String level;

    @Column(name = "rentprice")
    private String rentPrice;

    @Column(name = "rentprice_description")
    private String rentPriceDescription;

    @Column(name = "service_fee")
    private String serviceFee;

    @Column(name = "car_fee")
    private String carFee;

    @Column(name = "moto_fee")
    private String motoFee;

    @Column(name = "overtime_fee")
    private String overtimeFee;

    @Column(name = "water_fee")
    private String waterFee;

    @Column(name = "electricity_fee")
    private String electricityFee;

    @Column(name = "deposit")
    private String deposit;

    @Column(name = "payment")
    private String payment;

    @Column(name = "renttime")
    private String rentTime;

    @Column(name = "decorationtime")
    private String decorationTime;

    @Column(name = "brokerage_fee")
    private String brokerageFee;
    
    @Column(name = "type")
    private String typeCode;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_phone")
    private String managerPhone;

    @OneToMany(mappedBy = "building")
    private List<RentAreaEntity> rentAreas = new ArrayList<RentAreaEntity>();

    @ManyToOne
    @JoinColumn(name = "districtid")
    private DistrictEntity district;
}