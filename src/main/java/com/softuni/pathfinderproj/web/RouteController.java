package com.softuni.pathfinderproj.web;

import com.softuni.pathfinderproj.models.binding.RouteAddBindingModel;
import com.softuni.pathfinderproj.models.entity.enums.CategoryEnum;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;
import com.softuni.pathfinderproj.models.service.RouteServiceModel;
import com.softuni.pathfinderproj.services.RouteService;
import com.softuni.pathfinderproj.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RouteController {
    private final RouteService routeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, UserService userService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/routes")
    public String routes(Model model) {

        model.addAttribute("allRoutes", routeService.getAllRoutes());

        return "routes";
    }

    @GetMapping("/routes/{id}")
    public String routeId(Model model, @PathVariable Long id) {



        return "route-details";
    }

    @ModelAttribute()
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }

    @GetMapping("/routes/add")
    public String getAddRouteView(Model model) {
        if (!userService.isCurrentUserExist()) {
            return "redirect:/users/login";
        }

        model.addAttribute("levels", LevelEnum.values());
        model.addAttribute("categories", CategoryEnum.values());

        return "add-route";
    }

    @PostMapping("/routes/add")
    public String addRoute(@Valid RouteAddBindingModel routeAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("routeAddBindingModel",routeAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel", bindingResult);

            return "redirect:/routes/add";
        }

        RouteServiceModel serviceModel = modelMapper
                .map(routeAddBindingModel, RouteServiceModel.class);

        serviceModel.setGpxCoordinates(new String(routeAddBindingModel
                .getGpxCoordinates()
                .getBytes()));

        if (routeService.isThereAnotherRouteWithName(serviceModel.getName())) {
            redirectAttributes
                    .addFlashAttribute("routeExist",true);

            return "redirect:/routes/add";
        }

        routeService.addNewRoute(serviceModel);

        return "redirect:/routes";
    }
}
