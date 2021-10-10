package com.softuni.pathfinderproj.models.service;

import com.softuni.pathfinderproj.models.entity.RoleEntity;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;


import java.util.List;

public class UserServiceModel {

    private Long id;

    private String username;

    private String password;

    private String email;

    private List<RoleEntity> roles;

    private LevelEnum level;

    private Integer age;

    private String fullName;

    public UserServiceModel(){}

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}
