package com.loinguyen1905.realestate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "city")
public class CityEntity extends LocationEntity {
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<DistrictEntity> buildingEntities = new ArrayList<DistrictEntity>();
}