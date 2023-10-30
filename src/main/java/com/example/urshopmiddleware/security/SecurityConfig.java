package com.example.urshopmiddleware.security;


import com.example.urshopmiddleware.controller.ApiConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtUserDetailsConverter jwtUserDetailsConverter;

    public SecurityConfig(JwtUserDetailsConverter jwtUserDetailsConverter) {
        this.jwtUserDetailsConverter = jwtUserDetailsConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers(
                                            (ApiConstants.CATEGORIES + "/**"),
                                            (ApiConstants.PRODUCTS + "/**"), "/swagger-ui/**", "/v3/api-docs/**",
                                            //(ApiConstants.BASE_URL + ApiConstants.PRODUCTS + ApiConstants.GETBYCATEGORYTID+ApiConstants.BYID),
                                            (ApiConstants.AUTH + "/**"))
                                    .permitAll();
                            //                  .requestMatchers(ApiConstants.PRODUCTS + "/**")
                            //                  .hasAnyAuthority(Authority.ROLE_USER.getAuthority())
                            //                  .requestMatchers(ApiConstants.CASHIER + "/**")
                            //                  .hasAnyAuthority(Authority.ROLE_ADMIN.getAuthority());
                        })
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(
                        httpSecurityOAuth2ResourceServerConfigurer ->
                                httpSecurityOAuth2ResourceServerConfigurer.jwt(
                                        jwt -> {
                                            jwt.jwtAuthenticationConverter(jwtUserDetailsConverter);
                                        }))
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}
