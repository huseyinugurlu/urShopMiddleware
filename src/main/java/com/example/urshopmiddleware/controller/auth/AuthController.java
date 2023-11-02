package com.example.urshopmiddleware.controller.auth;


import com.example.urshopmiddleware.auth.AuthService;
import com.example.urshopmiddleware.controller.ApiConstants;
import com.example.urshopmiddleware.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.AUTH)
public class AuthController extends BaseController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(ApiConstants.CHANGE_PASSWORD)
    public void changePassword(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody final ResetPasswordRequest resetPasswordRequest) {
        this.authService.changePassword(jwtToken, resetPasswordRequest.getNewPassword());
    }

    @PostMapping(ApiConstants.LOGIN)
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

}
