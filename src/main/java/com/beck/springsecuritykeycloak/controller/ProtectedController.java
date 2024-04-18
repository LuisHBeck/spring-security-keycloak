package com.beck.springsecuritykeycloak.controller;

import com.beck.springsecuritykeycloak.dto.CookieInfoDto;
import com.beck.springsecuritykeycloak.dto.JWTInfoDto;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> privateRoute() {
        return ResponseEntity.ok("Protected route 🔐");
    }

    @GetMapping("/cookie")
    public ResponseEntity<CookieInfoDto> cookie(@AuthenticationPrincipal OidcUser user) {
        CookieInfoDto cookieInfo = new CookieInfoDto(
                "Protected route 🔐",
                user.getName(),
                user.getEmail(),
                user.getIdToken().getTokenValue(),
                user.getAuthorities().toString(),
                user.getAttribute("picture"),
                user);

        return ResponseEntity.ok(cookieInfo);
    }

    @GetMapping("/jwt")
    public ResponseEntity<JWTInfoDto> jwt(@AuthenticationPrincipal Jwt jwt) {
        JWTInfoDto jwtInfo = new JWTInfoDto(
                jwt.getTokenValue(),
                jwt.getClaim("email"),
                jwt.getClaims().toString()
        );

        return ResponseEntity.ok(jwtInfo);
    }

}
