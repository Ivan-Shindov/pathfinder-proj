package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.models.entity.RoleEntity;
import com.softuni.pathfinderproj.models.entity.UserEntity;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;
import com.softuni.pathfinderproj.models.entity.enums.RoleEnums;
import com.softuni.pathfinderproj.models.service.UserRegisterServiceModel;
import com.softuni.pathfinderproj.repositories.UserRepository;
import com.softuni.pathfinderproj.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerAndLogin(UserRegisterServiceModel userRegisterServiceModel) {

           if (!userRepository.existsByUsername(userRegisterServiceModel.getUsername())) {
                UserEntity userEntity = modelMapper.map(userRegisterServiceModel, UserEntity.class);
                userEntity.setLevel(LevelEnum.BEGINNER);

                userRepository.save(userEntity);
           }


    }
}
