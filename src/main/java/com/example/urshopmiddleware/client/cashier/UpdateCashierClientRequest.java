package com.example.urshopmiddleware.client.cashier;

import java.time.LocalDateTime;

public record UpdateCashierClientRequest(
        String userName, String email, LocalDateTime creationDate, long cashierNumber) {
}
