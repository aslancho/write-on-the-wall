package com.example.writeonthewall.controller;

import com.example.writeonthewall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("Passwords do not match!");
        }
        userService.registerUser(username, password, "USER");
        return "redirect:/login";
    }

}