package com.abdullahaktay.jwt.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @PrePersist
    protected void prePersist() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = Instant.now();
    }
}
