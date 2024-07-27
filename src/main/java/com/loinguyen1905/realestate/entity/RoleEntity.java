package com.loinguyen1905.realestate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntityAudit {
    @Column(name="name", nullable = false)
    private String name;

    @Column(name="code", unique = true, nullable = false)
    private String code;
}