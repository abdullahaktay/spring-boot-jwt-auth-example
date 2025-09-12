package com.abdullahaktay.jwt.dto.response;

import java.util.List;

public record AdminDashboardResponse(String message, String username, List<String> roles) {
}
