package com.example.urshopmiddleware.user;


import com.example.urshopmiddleware.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(int categoryId);

}
