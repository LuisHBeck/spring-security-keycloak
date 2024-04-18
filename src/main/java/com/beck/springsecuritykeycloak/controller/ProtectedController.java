package com.beck.springsecuritykeycloak.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
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

    @GetMapping("/cookie")
    public String cookie(@AuthenticationPrincipal OidcUser user) {
        return """
                <h1> Protected route 🔐</h1>
                <h2> IdToken: %s</h2>
                <h2> UserName: %s</h2>
                <h2> Authorities: %s</h2>             
                <h2> OidcUser: %s</h2>
                <img src="%s">        
                """
                .formatted(
                        user.getIdToken().getTokenValue(),
                        user.getEmail(),
                        user.getAuthorities(),
                        user,
                        user.getAttribute("picture")
                );
    }

    @GetMapping("/jwt")
    public String jwt(@AuthenticationPrincipal Jwt jwt) {
        return String.format(
                """
                JWT: %s \n
                EMAIL: %s \n
                CLAIMS: %s 
                """,
                jwt.getTokenValue(),
                jwt.getClaim("email"),
                jwt.getClaims()
        );
    }

}
