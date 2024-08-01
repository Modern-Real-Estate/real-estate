package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "role_detail",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<PermissionEntity> permissions;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;
}