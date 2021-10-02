package com.softuni.pathfinderproj.models.entity;

import com.softuni.pathfinderproj.models.entity.enums.RoleEnums;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleEnums name;

    public Role(){}


    public RoleEnums getName() {
        return name;
    }

    public Role setName(RoleEnums name) {
        this.name = name;
        return this;
    }
}
