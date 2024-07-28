package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "staff")
@DiscriminatorValue("staff")
@PrimaryKeyJoinColumn(name = "id")
public class StaffEntity extends UserEntity {
    @OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
    private List<CustomerEntity> customers;

    @OneToMany(mappedBy = "staff", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    private List<AssignmentBuildingEntity> assignmentBuilding;

    @OneToMany(mappedBy = "coordinator")
    private List<ContractEntity> contracts;

    @OneToMany(mappedBy = "staff")
    private List<TransactionEntity> transactions;
}