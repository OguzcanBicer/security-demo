package com.oguzcan.securitydemo.dto.request;

import lombok.Builder;

@Builder
public record AuthenticationRequestDTO(
        String username,
        String password
) {
}
