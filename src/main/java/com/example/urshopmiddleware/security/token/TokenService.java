package com.example.urshopmiddleware.security.token;


import com.example.urshopmiddleware.model.User;
import com.example.urshopmiddleware.security.SecurityUser;

public interface TokenService {
    String createToken(SecurityUser securityUser);

    User getUser(Object source);
}