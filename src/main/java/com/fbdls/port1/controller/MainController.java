package com.fbdls.port1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String healthCheck() {
        return "✅ I'm alive!";
    }

}
