package com.example.urshopmiddleware.model;

import java.util.Set;


public class Customer {
    private long id;
    private String name;
    private String email;
    private String password;
    private String authority;
    private String creationDate;
    private int customerNumber;
    private Set<Integer> orderIds;
    private Set<Integer> paymentCardIds;

}
