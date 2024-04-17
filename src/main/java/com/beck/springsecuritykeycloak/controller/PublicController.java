package com.beck.springsecuritykeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String publicRoute() {
        return """
                <h1> Public route 🔓 </h1>
                """;
    }
}
