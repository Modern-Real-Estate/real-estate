package com.loinguyen1905.realestate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "district")
public class DistrictEntity extends LocationEntity {
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id")
    private CityEntity city;
}