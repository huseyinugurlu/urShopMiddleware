package com.example.urshopmiddleware.client.customer;


import java.util.Set;

public record UpdateCustomerClientRequest(
        String userName,
        String email,
        int phoneNumber,
        Set<Integer> paymentCardIds) {
}
