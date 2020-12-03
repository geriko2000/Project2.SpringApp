package com.example.Project2.SpringApp.controller;

import com.example.Project2.SpringApp.domain.User;
import com.example.Project2.SpringApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){

        if(!userService.addUser(user)){
            model.addAttribute("message", "User Exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivate = userService.activateUser(code);

        if(isActivate){
            model.addAttribute("message", "Учетная запись активирована!");
        } else {
            model.addAttribute("message", "Код активации не найден");
        }

        return("login");
    }
}
