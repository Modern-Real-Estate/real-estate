package com.loinguyen1905.realestate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntityAudit {
    private static final long serialVersionUID = -6525302831793188081L; 

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="code", unique = true, nullable = false)
    private String code;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}