package com.loinguyen1905.realestate.entity;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
@DiscriminatorValue("customer")
@PrimaryKeyJoinColumn(name = "id")
public class CustomerEntity extends UserEntity {
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @OneToMany(mappedBy = "customer")
    private List<ContractEntity> contracts;

    @OneToMany(mappedBy = "customer")
    private List<TransactionEntity> transactions;
}