package com.example.writeonthewall.controller;

import com.example.writeonthewall.model.User;
import com.example.writeonthewall.service.CommentService;
import com.example.writeonthewall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WallController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("/wall")
    public String wall(Model model) {
        model.addAttribute("comments", commentService.getAllComments());
        return "wall";
    }

    @PostMapping("/wall")
    public String addComment(@RequestParam String content, @AuthenticationPrincipal UserDetails userDetails) {
        // Находим пользователя по его имени
        User user = userService.findByUsername(userDetails.getUsername());
        commentService.addComment(content, user);
        return "redirect:/wall";
    }
}