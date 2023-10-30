package com.example.urshopmiddleware.client.cashier;

public record GetByIdCashierClientResponse(
        String userName, String email, String creationDate, long cashierNumber) {
}
