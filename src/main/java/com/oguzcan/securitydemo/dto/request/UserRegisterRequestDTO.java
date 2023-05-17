package com.oguzcan.securitydemo.dto.request;

import com.oguzcan.securitydemo.model.enums.Role;
import lombok.Builder;

@Builder
public record UserRegisterRequestDTO(
        String username,
        String password,
        Role role
) {
}
