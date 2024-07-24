package com.loinguyen1905.realestate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.loinguyen1905.realestate.util.SecurityUtil;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntityAudit extends BaseEntity {
    @Column(name = "created_by", nullable = true)
    private String createdBy;

    @Column(name = "updated_by", nullable = true)
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", updatable = true)
    private Instant updatedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntityAudit)) return false;
        if (!super.equals(o)) return false;
        BaseEntityAudit that = (BaseEntityAudit) o;
        return createdBy.equals(that.createdBy) &&
                updatedBy.equals(that.updatedBy) &&
                createdDate.equals(that.createdDate) &&
                updatedDate.equals(that.updatedDate);
    }

    @Override
    public int hashCode() {
        return
            Objects.hash(super.hashCode(), createdBy, updatedBy, createdDate, updatedDate);
    }

    @PrePersist
    public void prePersist() {
        this.setCreatedBy(
          SecurityUtil.getCurrentUserLogin().isPresent() == true 
            ? SecurityUtil.getCurrentUserLogin().get()
            : null
        );
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdatedBy(
          SecurityUtil.getCurrentUserLogin().isPresent() == true 
            ? SecurityUtil.getCurrentUserLogin().get()
            : null
        );
    }
}