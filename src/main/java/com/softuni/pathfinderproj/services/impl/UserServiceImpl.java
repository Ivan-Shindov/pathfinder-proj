package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.models.entity.UserEntity;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;
import com.softuni.pathfinderproj.models.service.UserServiceModel;
import com.softuni.pathfinderproj.repositories.UserRepository;
import com.softuni.pathfinderproj.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerAndLogin(UserServiceModel userRegisterServiceModel) {

        // TODO register and login

           if (!userRepository.existsByUsername(userRegisterServiceModel.getUsername())) {
                UserEntity userEntity = modelMapper.map(userRegisterServiceModel, UserEntity.class);
                userEntity.setLevel(LevelEnum.BEGINNER);

                userRepository.save(userEntity);
           }


    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return this.userRepository.findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
