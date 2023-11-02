package com.example.urshopmiddleware.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private String authority;
    private String creationDate;
    private int phoneNumber;
    private Set<Integer> orderIds;
    private Set<Integer> paymentCardIds;

}
