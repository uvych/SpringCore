package com.gb.vtb.springcore.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping
    public String getNavigation(){
        return "index";
    }
}
