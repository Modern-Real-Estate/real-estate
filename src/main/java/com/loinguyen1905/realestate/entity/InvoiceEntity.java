package com.loinguyen1905.realestate.entity;

import java.util.List;

import com.loinguyen1905.realestate.common.PaymentFrequency;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "invoice")
public class InvoiceEntity extends BaseEntityAudit {
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PaymentHistoryEntity> payments;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_frequency")
    private PaymentFrequency paymentFrequency;

    @Column(name = "status")
    private String status;
}