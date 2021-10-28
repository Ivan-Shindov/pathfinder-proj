package com.softuni.pathfinderproj.services;

import com.softuni.pathfinderproj.models.service.RouteServiceModel;
import com.softuni.pathfinderproj.models.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> getAllRoutes();

    RouteServiceModel addNewRoute(RouteServiceModel routeAddBindingModel);

    boolean isThereAnotherRouteWithName(String name);
}
