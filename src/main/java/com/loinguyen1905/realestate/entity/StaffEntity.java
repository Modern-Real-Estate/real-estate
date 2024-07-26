package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany(mappedBy = "staffs")
    private List<CustomerEntity> customers;
}