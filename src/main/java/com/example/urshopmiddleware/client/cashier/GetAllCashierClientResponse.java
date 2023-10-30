package com.example.urshopmiddleware.client.cashier;

public record GetAllCashierClientResponse(
        String userName, String email, String creationDate, long cashierNumber) {
}
