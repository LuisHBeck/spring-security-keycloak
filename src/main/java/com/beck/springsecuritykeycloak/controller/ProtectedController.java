package com.beck.springsecuritykeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedController {

    @GetMapping
    public String privateRoute() {
        return """
                <h1> Protected route 🔐</h1>
                """;
    }
}
