package com.loinguyen1905.realestate.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntityAudit {

    @Column(name = "value", nullable = false)
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "building_id")
    BuildingEntity building;
    
    @PrePersist
    public void prePersist() {
        super.prePersist();
    }
}