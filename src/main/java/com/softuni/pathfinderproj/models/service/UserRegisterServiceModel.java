package com.softuni.pathfinderproj.models.service;

import com.softuni.pathfinderproj.models.entity.RoleEntity;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;


import java.util.List;

public class UserRegisterServiceModel {

    private String username;

    private String password;

    private String email;

    private List<RoleEntity> roles;

    private LevelEnum level;

    private Integer age;

    private String fullName;

    public UserRegisterServiceModel(){}

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public UserRegisterServiceModel setRoles(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserRegisterServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
