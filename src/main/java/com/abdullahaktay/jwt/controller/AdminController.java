package com.abdullahaktay.jwt.controller;

import com.abdullahaktay.jwt.dto.response.AdminDashboardResponse;
import com.abdullahaktay.jwt.service.AdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize( "hasRole('ADMIN')")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/dashboard")
    public AdminDashboardResponse dashboard(Authentication authentication) {
        return adminService.getDashboard(authentication);
    }
}
