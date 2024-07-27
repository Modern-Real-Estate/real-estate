package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "contract")
public class ContractEntity extends BaseEntityAudit {
    private String status;
    private List<ContractInvoiceEntity> contractInvoices;
    private PaymentFrequencyEntity paymentFrequency;
    private ContractTypeEntity contractType;
    private List<BuildingEntity> buildings;
}