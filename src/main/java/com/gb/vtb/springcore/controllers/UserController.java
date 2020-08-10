package com.gb.vtb.springcore.controllers;

import com.gb.vtb.springcore.model.User;
import com.gb.vtb.springcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllActions(){
        return "action_user";
    }

    @GetMapping("/all")
    public String getAllUser(Model model){
        model.addAttribute("frontUser", userService.getAllUsers());
        return "all_user";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/add")
    public String getAddForm(){
        return "add_user_form";
    }

    @GetMapping("/id_form")
    public String getIdForm(){
        return "find_by_id_form_user";
    }

    @GetMapping("/find")
    public String getUserById(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user_by_id";
    }
}
