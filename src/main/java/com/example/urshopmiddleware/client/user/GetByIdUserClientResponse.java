package com.example.urshopmiddleware.client.user;

public record GetByIdUserClientResponse(int id, String userName, String email, String authority, String creationDate) {
}
