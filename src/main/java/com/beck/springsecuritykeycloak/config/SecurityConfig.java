package com.beck.springsecuritykeycloak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(withDefaults())
                .oauth2ResourceServer(conf -> conf
                        .jwt(withDefaults()));

        return http.build();
    }
}
