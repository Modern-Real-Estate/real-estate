package com.loinguyen1905.realestate.entity;

import java.time.Instant;
import java.util.List;

import com.loinguyen1905.realestate.common.ContractType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "contract")
public class ContractEntity extends BaseEntityAudit {
    @Column(name = "status", nullable = false)
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ContractType contractType;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "interest_rate")
    private Double interestRate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity coordinator;

    // @ManyToOne
    // @JoinColumn(name = "lawyer_id")
    // private LawyerEntity lawyer;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;

    @OneToMany(
        mappedBy = "contract", 
        cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    private List<InvoiceEntity> invoices;

    // @ManyToOne
    // @JoinColumn(name = "paymentfrequency_id")
    // private PaymentFrequencyEntity paymentFrequency;
}