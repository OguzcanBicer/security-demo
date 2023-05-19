package com.oguzcan.securitydemo.dto.response;

import lombok.Builder;

@Builder
public record UserTokenResponseDTO(
        String accessToken,
        String refreshToken
) {
}
