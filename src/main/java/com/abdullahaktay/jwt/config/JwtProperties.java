package com.abdullahaktay.jwt.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;

@ConfigurationProperties(prefix = "app.jwt")
@Validated
public record JwtProperties(@NotNull RSAPublicKey publicKey,
                            @NotNull RSAPrivateKey privateKey,
                            @NotNull Duration ttl) {
}
