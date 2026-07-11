package com.scrip.msuserauthregister.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/protected")
    public String secureEndpoint() {
        return "¡Felicidades! Cruzaste el API Gateway de forma segura usando tu JWT.";
    }
}
