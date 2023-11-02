package com.example.urshopmiddleware.client.cashier;

public record UpdateCashierClientRequest(
        String userName, String email, int phoneNumber) {
}
