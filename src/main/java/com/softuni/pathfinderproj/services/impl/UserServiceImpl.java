package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.models.entity.UserEntity;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;
import com.softuni.pathfinderproj.models.service.UserServiceModel;
import com.softuni.pathfinderproj.repositories.UserRepository;
import com.softuni.pathfinderproj.services.UserService;
import com.softuni.pathfinderproj.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerAndLogin(UserServiceModel userRegisterServiceModel) {

           if (!userRepository.existsByUsername(userRegisterServiceModel.getUsername())) {
                UserEntity userEntity = modelMapper.map(userRegisterServiceModel, UserEntity.class);
                userEntity.setLevel(LevelEnum.BEGINNER);

                userRepository.save(userEntity);
           }

           loginUser(userRegisterServiceModel.getId(),userRegisterServiceModel.getUsername());
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return this.userRepository.findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    public void loginUser(Long id, String username) {
        currentUser
                .setId(id)
                .setUsername(username);
    }

    @Override
    public void logout() {
        currentUser.clearFields();
    }

    @Override
    public UserServiceModel findById(Long id) {

        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
