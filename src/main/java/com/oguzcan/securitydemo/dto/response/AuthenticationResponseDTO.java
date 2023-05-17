package com.oguzcan.securitydemo.dto.response;

import lombok.Builder;

@Builder
public record AuthenticationResponseDTO(
        String accessToken,
        String refreshToken
) {
}
