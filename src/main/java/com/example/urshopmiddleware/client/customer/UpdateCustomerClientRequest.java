package com.example.urshopmiddleware.client.customer;


import java.time.LocalDateTime;
import java.util.Set;

public record UpdateCustomerClientRequest(
        String userName,
        String email,
        LocalDateTime creationDate,
        int customerNumber,
        Set<Integer> orderIds,
        Set<Integer> paymentCardIds) {
}
