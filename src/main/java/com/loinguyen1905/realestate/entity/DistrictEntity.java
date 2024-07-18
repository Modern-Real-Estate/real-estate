package com.loinguyen1905.realestate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// @Builder
@Table(name = "district")
public class DistrictEntity extends BaseEntity { 
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    // @Builder.Default
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

    @ManyToOne
    @JoinColumn(name = "cityid")
    private CityEntity city;
}