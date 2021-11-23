package com.softuni.pathfinderproj.services;

import com.softuni.pathfinderproj.models.service.UserServiceModel;

public interface UserService {

    void registerAndLogin(UserServiceModel userRegisterServiceModel);

    boolean isUsernameExists(String username);

    UserServiceModel findById(Long id);
}
