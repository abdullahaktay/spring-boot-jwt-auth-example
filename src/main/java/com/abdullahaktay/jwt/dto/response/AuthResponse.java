package com.abdullahaktay.jwt.dto.response;

public record AuthResponse(String accessToken, String tokenType, long expiresIn) {}
