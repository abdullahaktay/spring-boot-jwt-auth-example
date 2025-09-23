package com.abdullahaktay.jwt.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "privileges")
public class Privilege extends BaseEntity{

    @Column(nullable = false)
    private String name;
}
