package com.example.urshopmiddleware.security;


import com.example.urshopmiddleware.controller.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public SecurityConfig(JwtUserDetailsConverter jwtUserDetailsConverter) {
        this.jwtUserDetailsConverter = jwtUserDetailsConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers(
                                            (ApiConstants.PRODUCTS + "/**"),
                                            (ApiConstants.CATEGORIES + "/**"),
                                            (ApiConstants.CASHIER + "/**"),
                                            (ApiConstants.AUTH + "/**"),
                                            (ApiConstants.CUSTOMER_OFFER + "/**"),
                                            (ApiConstants.PAYMENT_CARDS + "/**"),
                                            (ApiConstants.ORDERS + "/**"),
                                            (ApiConstants.PRODUCT_CUSTOMER_OFFER_MAP + "/**"),
                                            (ApiConstants.PRODUCT_FEATURE_VALUE_MAP + "/**"),
                                            (ApiConstants.CUSTOMER + "/**"),
                                            (ApiConstants.PRODUCTS + "/**"),
                                            (ApiConstants.USER + "/**"),
                                            "/v3/api-docs/**",
                                            "/swagger-ui/**"
                                    ).permitAll();
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
