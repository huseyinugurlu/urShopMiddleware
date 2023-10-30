package com.example.urshopmiddleware.security.token;


import com.example.urshopmiddleware.security.SecurityUser;
import com.example.urshopmiddleware.model.User;

public interface TokenService {
  String createToken(SecurityUser securityUser);

  User getUser(Object source);
}