package com.example.urshopmiddleware.client.customer;

import java.util.Set;

public record CreateCustomerClientRequest(
        String userName,
        String email,
        String password,
        int customerNumber,
        Set<Integer> paymentCardIds) {
}
