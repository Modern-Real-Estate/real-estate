package com.loinguyen1905.realestate.entity;
import java.util.List;

import com.loinguyen1905.realestate.common.PaymentMethod;

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
@Table(name = "payment_history")
public class PaymentHistoryEntity extends BaseEntityAudit {
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    @Column(name = "remain_amount")
    private String remainAmount;

    @Column(name = "paid_amount")
    private String paidAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "status")
    private String status;
}