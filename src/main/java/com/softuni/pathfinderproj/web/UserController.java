package com.softuni.pathfinderproj.web;

import com.softuni.pathfinderproj.models.binding.UserLoginBindingModel;
import com.softuni.pathfinderproj.models.binding.UserRegisterBindingModel;
import com.softuni.pathfinderproj.models.service.UserServiceModel;
import com.softuni.pathfinderproj.models.view.UserViewModel;
import com.softuni.pathfinderproj.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/users/login")
    public String login(Model model) {
        if (!model.containsAttribute("isExist")) {
            model.addAttribute("isExist", true);
        }

        return "login";
    }

    @PostMapping("/users/login")
    public String postLogin(@Valid UserLoginBindingModel userLoginBindingModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = this.userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("isExist", false)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        this.userService.loginUser(userServiceModel.getId()
                , userServiceModel.getUsername());

        return "redirect:/";
    }


    @GetMapping("/users/register")
    public String register() {

        return "register";
    }

    @PostMapping("/users/register")
    public String postRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }


        if (userService.isUsernameExists(userRegisterBindingModel.getUsername())) {
            redirectAttributes
                    .addFlashAttribute("usernameExist", true)
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);

            return "redirect:/users/register";
        }

        userService
                .registerAndLogin(modelMapper
                        .map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("users/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }


    @GetMapping("users/profile/{id}")
    public String profile(@PathVariable Long id,
                          Model model) {

        if (!userService.isCurrentUserExist()) {
            return "redirect:/users/login";
        }

        UserViewModel viewModel = modelMapper.map(userService.findById(id), UserViewModel.class);
        model.addAttribute("user", viewModel);


        return "profile";
    }
}
