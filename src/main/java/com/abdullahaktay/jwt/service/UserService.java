package com.abdullahaktay.jwt.service;

import com.abdullahaktay.jwt.dto.response.UserProfileResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserProfileResponse getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return new UserProfileResponse(username, roles);
    }
}
