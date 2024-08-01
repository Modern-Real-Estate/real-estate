package com.loinguyen1905.realestate.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "permission")
public class PermissionEntity extends BaseEntityAudit {
    @Column(nullable = true, name = "name")
    private String name;

    @Column(nullable = true, name = "code")
    private String code;

    @Column(nullable = true, name = "api_path")
    private String apiPath;

    @Column(nullable = true, name = "method")
    private String method;

    @Column(nullable = true, name = "module")
    private String module;

    @ManyToMany(mappedBy = "permissions")
    private List<RoleEntity> roles;

    @PrePersist
    public void prePersist() {
        this.code = this.apiPath + " " + this.method + " " + this.module;
    }
}