package com.example.urshopmiddleware.controller.user;


import com.example.urshopmiddleware.model.User;

public record GetByIdUserResponse(int id,String userName, String email, String creationDate) {

    public static GetByIdUserResponse fromUser(User user) {
        return new GetByIdUserResponse(user.getId(), user.getName(), user.getEmail(), user.getCreationDate());
    }
}
