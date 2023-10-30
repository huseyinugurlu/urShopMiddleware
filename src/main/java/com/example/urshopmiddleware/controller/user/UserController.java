package com.example.urshopmiddleware.controller.user;


import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.controller.BaseController;
import com.example.urshopmiddleware.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiConstants.CASHIER)
public class UserController extends BaseController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiConstants.GET_ALL)
    public ResponseEntity<?> getAll() {
        final List<GetAllUserResponse> data=GetAllUserResponse.fromUsers(userService.getAll());
        return success(data);
    }

    @GetMapping(ApiConstants.BY_ID)
    public ResponseEntity<?> getByIdUserResponse(@PathVariable int id) {
        final GetByIdUserResponse data=GetByIdUserResponse.fromUser(userService.getById(id));
        return success(data);
    }

}
