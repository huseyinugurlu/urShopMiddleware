package com.example.urshopmiddleware.client.auth;

import lombok.Getter;

@Getter
public class ResetPasswordClientRequest {
    private String newPassword;

    public ResetPasswordClientRequest(String newPassword) {
    }
}
