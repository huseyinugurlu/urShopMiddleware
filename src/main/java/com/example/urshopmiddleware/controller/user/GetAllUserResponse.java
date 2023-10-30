package com.example.urshopmiddleware.controller.user;


import com.example.urshopmiddleware.model.User;

import java.util.List;

public record GetAllUserResponse(String userName, String email, String creationDate) {

    public static List<GetAllUserResponse> fromUsers(List<User> users) {
        return users.stream().map(GetAllUserResponse::fromUser).toList();
    }

    public static GetAllUserResponse fromUser(User user) {
        return new GetAllUserResponse(user.getName(), user.getEmail(), user.getCreationDate());
    }
}
