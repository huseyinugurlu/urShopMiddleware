package com.example.urshopmiddleware.client.customer;

import java.time.LocalDateTime;
import java.util.Set;

public record CreateCustomerClientRequest(
        String userName,
        String email,
        String password,
        LocalDateTime creationDate,
        int customerNumber,
        Set<Integer> orderIds,
        Set<Integer> paymentCardIds) {
}
