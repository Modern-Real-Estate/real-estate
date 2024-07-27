package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "building_type")
public class BuildingTypeEntity extends BaseEntityAudit {
    @ManyToMany(mappedBy = "buildingTypes")
    private List<BuildingEntity> buildings;
}