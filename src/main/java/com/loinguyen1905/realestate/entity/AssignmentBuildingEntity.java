package com.loinguyen1905.realestate.entity;
import java.util.UUID;

import com.loinguyen1905.realestate.common.AssignmentRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "assignment_building")
public class AssignmentBuildingEntity extends BaseEntityAudit {
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private StaffEntity staff;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private AssignmentRole role;
}