package com.example.urshopmiddleware.client.cashier;

public record CreateCashierClientRequest(
        String userName,
        String email,
        String password,
        long cashierNumber) {
}
