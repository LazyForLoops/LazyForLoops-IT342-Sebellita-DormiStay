package edu.cit.sebellita.backend.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String showUserRegister(){
        return "";
    }

    @GetMapping("/new")
    public String showUserNewAccountPage(){
        return "";
    }

    @PostMapping
    public String postUserRecord(){
        return "";
    }
}
