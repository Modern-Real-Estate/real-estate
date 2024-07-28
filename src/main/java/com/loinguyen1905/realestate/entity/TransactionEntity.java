package com.loinguyen1905.realestate.entity;

import com.loinguyen1905.realestate.common.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntityAudit {
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private StaffEntity staff;

    @Column(name = "tip", nullable = true)
    private Double tip;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(columnDefinition = "MEDIUMTEXT", name = "description", nullable = true)
    private String description;

    @PrePersist
    public void prePersist() {
        if(this.tip == null) this.tip = 0.0;
    }
}