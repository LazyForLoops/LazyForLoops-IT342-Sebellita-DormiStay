package edu.cit.sebellita.backend.index.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cit.sebellita.backend.user.dto.UserRegisterRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserRegisterRequest());
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}