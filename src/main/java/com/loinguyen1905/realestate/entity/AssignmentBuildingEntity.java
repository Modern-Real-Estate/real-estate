package com.loinguyen1905.realestate.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "assignment_building")
public class AssignmentBuildingEntity extends BaseEntityAudit {
    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @Column(name = "manager_id")
    private UUID managerId;
    
    // @PrePersist
}