package com.loinguyen1905.realestate.entity;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.Column;
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
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(columnDefinition = "MEDIUMTEXT", name = "description", nullable = true)
    private String description;

    @ManyToMany(mappedBy = "buildingTypes")
    private List<BuildingEntity> buildings;
}