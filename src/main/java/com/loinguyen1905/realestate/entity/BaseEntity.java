package com.loinguyen1905.realestate.entity;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    
    private static final long serialVersionUID = -863164858986274318L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @CreatedDate
    @Column(name = "createddate")
    private Instant createdDate;

    @CreatedBy
    @Column(name = "createdby")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "modifieddate")
    private Instant modifiedDate = null;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy = null;

    @PrePersist
    public void prePersist() {
        this.modifiedBy = null;
        this.modifiedDate = null;
    }
}