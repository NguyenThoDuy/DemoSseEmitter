package com.tutorial.Common.controller;

import com.tutorial.Common.request.LoginRequest;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AuthenController {
    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

//    @PostMapping("/login")
//    public String viewLoginPage(Model model, @ModelAttribute LoginRequest request) {
//        model.addAttribute("loginRequest", new LoginRequest());
//        return "login";
//    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }
}
