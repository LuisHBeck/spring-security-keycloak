package com.beck.springsecuritykeycloak.dto;

public record JWTInfoDto(
        String tokenJWT,
        String email,
        String claims

) {
}
