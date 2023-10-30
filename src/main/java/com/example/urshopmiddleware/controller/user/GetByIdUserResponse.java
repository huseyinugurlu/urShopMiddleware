package com.example.urshopmiddleware.controller.user;


import com.example.urshopmiddleware.model.User;

public record GetByIdUserResponse(String userName, String email, String creationDate) {

    public static GetByIdUserResponse fromUser(User user){
        return new GetByIdUserResponse(user.getName(),user.getEmail(), user.getCreationDate());
    }
}
