package com.abdullahaktay.jwt.service;

import com.abdullahaktay.jwt.dto.request.AuthRequest;
import com.abdullahaktay.jwt.dto.response.AuthResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class AuthService {
    private static final Duration ACCESS_TTL = Duration.ofMinutes(15);
    private static final String TOKEN_PREFIX = "Bearer ";

    public AuthResponse login(AuthRequest authRequest){
        var token = "dummyToken";
        return new AuthResponse(token, TOKEN_PREFIX, ACCESS_TTL.toSeconds());

    }
}
