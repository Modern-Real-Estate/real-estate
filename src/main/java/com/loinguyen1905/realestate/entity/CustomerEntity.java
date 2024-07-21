package com.loinguyen1905.realestate.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
    private static final long serialVersionUID = -4988455421375043688L;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", nullable = true)
    private String phone;
}