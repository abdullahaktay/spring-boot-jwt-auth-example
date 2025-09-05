package com.abdullahaktay.jwt.controller;

import com.abdullahaktay.jwt.dto.request.AuthRequest;
import com.abdullahaktay.jwt.dto.response.AuthResponse;
import com.abdullahaktay.jwt.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest authRequest){
        return authService.login(authRequest);
    }
}
