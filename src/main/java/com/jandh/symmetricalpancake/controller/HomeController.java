package com.jandh.symmetricalpancake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = {"", "index.html"})
    public String index() {
        return "index";
    }
}
