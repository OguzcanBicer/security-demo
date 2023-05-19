package com.oguzcan.securitydemo.dto.request;

import lombok.Builder;

@Builder
public record UserLoginRequestDTO(
        String username,
        String password
) {
}
