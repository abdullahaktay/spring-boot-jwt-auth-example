package com.abdullahaktay.jwt.service;

import com.abdullahaktay.jwt.config.JwtProperties;
import com.abdullahaktay.jwt.dto.request.AuthRequest;
import com.abdullahaktay.jwt.dto.response.AuthResponse;
import com.abdullahaktay.jwt.model.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final AuthenticationManager authenticationManager;

    public AuthService(JwtEncoder jwtEncoder, JwtProperties jwtProperties, AuthenticationManager authenticationManager) {
        this.jwtEncoder = jwtEncoder;
        this.jwtProperties = jwtProperties;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(authRequest.username(), authRequest.password());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authentication);
        var ttl = jwtProperties.ttl();
        String token = generateToken(authenticationResponse.getName(), ttl);
        return new AuthResponse(token, TOKEN_TYPE, ttl.toSeconds());
    }

    private String generateToken(String subject, Duration ttl) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(now)
                .expiresAt(now.plus(ttl))
                .claim("scope", Role.USER.name())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
