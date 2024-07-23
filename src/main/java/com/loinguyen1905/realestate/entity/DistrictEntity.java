package com.loinguyen1905.realestate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntityAudit { 
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @PrePersist
    public void prePersist() {
        super.prePersist();
    }
}