package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// @Setter
// @Getter
// @Entity
// @Table(name = "lawyer")
public class LawyerEntity {
    // @OneToMany(mappedBy = "lawyer", orphanRemoval = false, fetch = FetchType.EAGER)
    // private List<ContractEntity> contracts;
}