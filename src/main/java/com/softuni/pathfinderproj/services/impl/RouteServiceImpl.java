package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.models.entity.PictureEntity;
import com.softuni.pathfinderproj.models.entity.RouteEntity;
import com.softuni.pathfinderproj.models.entity.UserEntity;
import com.softuni.pathfinderproj.models.service.RouteServiceModel;
import com.softuni.pathfinderproj.models.view.RouteViewModel;
import com.softuni.pathfinderproj.repositories.RouteRepository;
import com.softuni.pathfinderproj.services.CategoryService;
import com.softuni.pathfinderproj.services.RouteService;
import com.softuni.pathfinderproj.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeReposiotry;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeReposiotry, ModelMapper modelMapper,
                            UserService userService, CategoryService categoryService) {
        this.routeReposiotry = routeReposiotry;
        this.modelMapper = modelMapper;
        this.userService = userService;

        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> getAllRoutes() {

        return routeReposiotry.findAll()
                .stream()
                .map(routeEntity -> {
                    RouteViewModel routeViewModel = modelMapper.map(routeEntity, RouteViewModel.class);
                    routeViewModel.setPicture(
                            routeEntity.getPictures()
                                    .stream()
                                    .map(PictureEntity::getUrl)
                                    .findFirst()
                                    .orElse("/images/pic3.jpg"));
                    return routeViewModel;
                })
                .collect(Collectors.toList());

    }

    @Override
    public RouteServiceModel addNewRoute(RouteServiceModel routeAddServiceModel) {

        RouteEntity routeEntity = modelMapper.map(routeAddServiceModel, RouteEntity.class);
        UserEntity user = userService.findCurrentUser();

        routeEntity.setAuthor(user);
        routeEntity.setCategories(routeAddServiceModel
                .getCategories()
                .stream()
                .map(categoryEnum -> categoryService.findByCategoryName(categoryEnum))
                .collect(Collectors.toSet()));

        routeReposiotry.save(routeEntity);

        return routeAddServiceModel;

    }

    @Override
    public boolean isThereAnotherRouteWithName(String name) {
        RouteEntity routeEntity = routeReposiotry.findByName(name).orElse(null);

        return routeEntity == null ? false : true;
    }
}

