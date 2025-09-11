package com.abdullahaktay.jwt.dto.response;

import java.util.List;

public record UserProfileResponse(String username, List<String> roles) {
}
