package com.softuni.pathfinderproj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/users/login")
    public String login() {


        return "login";
    }

    @GetMapping("/users/register")
    public String register(){

        return "register";
    }

}
