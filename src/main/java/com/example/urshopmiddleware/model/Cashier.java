package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cashier {
    private int id;
    private String name;
    private String email;
    private String password;
    private String authority;
    private String creationDate;
    private int phoneNumber;
}
