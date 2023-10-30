package com.example.urshopmiddleware.client.cashier;

public record GetAllCashierClientResponse(
        int id, String userName, String email, String creationDate, long cashierNumber) {
}
