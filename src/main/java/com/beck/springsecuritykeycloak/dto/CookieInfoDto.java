package com.beck.springsecuritykeycloak.dto;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public record CookieInfoDto(
        String routeAccessType,
        String userName,
        String email,
        String idToken,
        String authorities,
        String profilePictureUrl,
        OidcUser oidcUser

) {
}
