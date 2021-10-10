package com.softuni.pathfinderproj.services;

import com.softuni.pathfinderproj.models.service.UserRegisterServiceModel;

public interface UserService {
    void registerAndLogin(UserRegisterServiceModel userRegisterServiceModel);
}
