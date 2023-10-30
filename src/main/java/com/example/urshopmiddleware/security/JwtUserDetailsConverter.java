package com.example.urshopmiddleware.security;


import com.example.urshopmiddleware.security.token.TokenService;
import com.example.urshopmiddleware.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtUserDetailsConverter implements Converter<Jwt, AbstractAuthenticationToken> {
  private final TokenService tokenService;

  public JwtUserDetailsConverter(@Lazy final TokenService tokenService) {
    this.tokenService = tokenService;
  }

  @Override
  public AbstractAuthenticationToken convert(final Jwt source) {
    final User user = tokenService.getUser(source);
    return new UsernamePasswordAuthenticationToken(
        user, user.getPassword(), List.of(Authority.valueOf(user.getAuthority())));
  }
}