package com.oguzcan.securitydemo.dto.request;

public record UserLoginRequestDTO(
        String username,
        String password
) {
}
