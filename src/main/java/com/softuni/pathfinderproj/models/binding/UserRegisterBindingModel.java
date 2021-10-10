package com.softuni.pathfinderproj.models.binding;

import com.softuni.pathfinderproj.models.entity.RoleEntity;
import com.softuni.pathfinderproj.models.entity.enums.RoleEnums;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {

    @Length(min = 2)
    @NotNull
    private String username;

    @NotNull
    private String fullName;

    @Email
    @NotNull
    private String email;

    @Min(4)
    @Max(99)
    private Integer age;

    @Length(min = 2)
    @NotNull
    private String password;

    @Length(min = 2)
    @NotNull
    private String confirmPassword;



    public UserRegisterBindingModel() {

    }


    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }


}
