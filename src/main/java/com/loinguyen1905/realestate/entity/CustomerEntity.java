package com.loinguyen1905.realestate.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntityAudit {

    private static final long serialVersionUID = -4988455421375043688L;

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
    
    @PrePersist
    public void prePersist() {
        this.status = true;
    }
}