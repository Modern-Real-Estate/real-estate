package com.loinguyen1905.realestate.entity;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = StaffEntity.class, name = "staff"),
    @JsonSubTypes.Type(value = CustomerEntity.class, name = "customer"),
})
public class UserEntity extends BaseEntityAudit {
    @Column(name = "frist_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "email", unique = true) 
    private String email;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    
    @PrePersist
    public void prePersist() {
        this.status = true;
    }
}