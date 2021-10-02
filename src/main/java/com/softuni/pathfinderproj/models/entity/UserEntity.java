package com.softuni.pathfinderproj.models.entity;

import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @ManyToMany
    private List<RoleEntity> roles;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @Column
    private Integer age;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    public UserEntity(){}

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<RoleEntity> getRole() {
        return roles;
    }

    public UserEntity setRole(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserEntity setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
