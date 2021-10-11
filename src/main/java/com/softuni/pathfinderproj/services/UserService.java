package com.softuni.pathfinderproj.services;

import com.softuni.pathfinderproj.models.service.UserServiceModel;

public interface UserService {


    void registerAndLogin(UserServiceModel userRegisterServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id,String username);

    void logout();

    UserServiceModel findById(Long id);
}
