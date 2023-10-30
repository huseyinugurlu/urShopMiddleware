package com.example.urshopmiddleware.client.customer;


import java.util.Set;

public record GetByIdCustomerClientResponse(
        String userName,
        String email,
        String creationDate,
        int customerNumber,
        Set<Integer> orderIds,
        Set<Integer> paymentCardIds) {
}
