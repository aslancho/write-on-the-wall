package com.example.writeonthewall.controller;

import com.example.writeonthewall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profilePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        return "profile";
    }

    @GetMapping("/profile/settings")
    public String settingsPage() {
        return "settings";
    }

    @PostMapping("/profile/delete")
    public String deleteAccount(@AuthenticationPrincipal UserDetails userDetails) {
        userService.deleteUser(userDetails.getUsername());
        return "redirect:/login?logout";
    }
}
