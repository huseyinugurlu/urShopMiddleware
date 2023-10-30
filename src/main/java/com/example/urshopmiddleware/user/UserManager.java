package com.example.urshopmiddleware.user;


import com.example.urshopmiddleware.client.UrShopClient;
import com.example.urshopmiddleware.client.user.GetByIdUserClientResponse;
import com.example.urshopmiddleware.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    private final UrShopClient urShopClient;

    @Autowired
    public UserManager(UrShopClient userClient) {
        this.urShopClient = userClient;
    }

    @Override
    public List<User> getAll() {
        return urShopClient.getAllUser().stream()
                .map(getAllUserClientResponse ->
                        User.builder()
                                .id(getAllUserClientResponse.id())
                                .name(getAllUserClientResponse.userName())
                                .email(getAllUserClientResponse.email())
                                .creationDate(getAllUserClientResponse.creationDate())
                                .authority(getAllUserClientResponse.authority())
                                .build()
                ).collect(Collectors.toList());
    }

    @Override
    public User getById(int id) {
        final GetByIdUserClientResponse byIdUser = urShopClient.getByIdUser(id);
        return User.builder()
                .name(byIdUser.userName())
                .email(byIdUser.email())
                .authority(byIdUser.authority())
                .creationDate(byIdUser.creationDate())
                .build();
    }

}
