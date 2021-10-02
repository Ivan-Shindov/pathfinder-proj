package com.softuni.pathfinderproj.models.entity;

import com.softuni.pathfinderproj.models.entity.enums.RoleEnums;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnums role;

    public RoleEntity(){}

    public RoleEnums getRole() {
        return role;
    }

    public RoleEntity setRole(RoleEnums role) {
        this.role = role;
        return this;
    }
}
