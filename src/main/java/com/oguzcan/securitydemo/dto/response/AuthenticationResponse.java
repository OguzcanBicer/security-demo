package com.oguzcan.securitydemo.dto.response;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String accessToken,
        String refreshToken
) {
}
