package com.abdullahaktay.jwt.controller;

import com.abdullahaktay.jwt.dto.response.UserProfileResponse;
import com.abdullahaktay.jwt.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserProfileResponse getCurrentUser(Authentication authentication) {
        return userService.getCurrentUser(authentication);
    }
}
