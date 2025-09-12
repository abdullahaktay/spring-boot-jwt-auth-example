package com.abdullahaktay.jwt.service;

import com.abdullahaktay.jwt.dto.response.AdminDashboardResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    public AdminDashboardResponse getDashboard(Authentication authentication) {
        String message = "Welcome to the amin dashboard";
        String username = authentication.getName();
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return new AdminDashboardResponse(message, username, roles);
    }
}
