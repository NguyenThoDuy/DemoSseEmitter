package com.tutorial.Common.controller;

import com.tutorial.Common.service.imp.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenController {
    private final UserService userService;

    public AuthenController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/chat")
    public String chat(Model model){
        var data = userService.getMesage();
        System.out.println(data);
        model.addAttribute("messResponse", data);
        return "chat";
    }
}
