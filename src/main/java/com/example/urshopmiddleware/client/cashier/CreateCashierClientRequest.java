package com.example.urshopmiddleware.client.cashier;

import java.time.LocalDateTime;

public record CreateCashierClientRequest(
        int id,
        String userName,
        String email,
        String password,
        LocalDateTime creationDate,
        long cashierNumber) {
}
