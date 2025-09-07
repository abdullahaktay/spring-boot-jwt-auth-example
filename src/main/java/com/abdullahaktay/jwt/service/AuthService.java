package com.abdullahaktay.jwt.service;

import com.abdullahaktay.jwt.config.JwtProperties;
import com.abdullahaktay.jwt.dto.request.AuthRequest;
import com.abdullahaktay.jwt.dto.response.AuthResponse;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class AuthService {
    private static final String TOKEN_TYPE = "Bearer";
    private final JwtEncoder jwtEncoder;
    private final JwtProperties jwtProperties;

    public AuthService(JwtEncoder jwtEncoder, JwtProperties jwtProperties) {
        this.jwtEncoder = jwtEncoder;
        this.jwtProperties = jwtProperties;
    }

    public AuthResponse login(AuthRequest authRequest) {
        var ttl = jwtProperties.ttl();
        String token = generateToken(authRequest.username(), ttl);
        return new AuthResponse(token, TOKEN_TYPE, ttl.toSeconds());

    }

    private String generateToken(String subject, Duration ttl) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(now)
                .expiresAt(now.plus(ttl))
                .claim("scope", "USER")
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();


    }
}
