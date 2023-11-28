package com.ling.jsb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }

    @GetMapping("/")
    public String toIndexNormal(){
        return "index";
    }
}