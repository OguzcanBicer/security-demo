package com.oguzcan.securitydemo.dto.request;

import com.oguzcan.securitydemo.model.enums.Role;

public record UserRegisterRequestDTO(
            String username,
            String password,
            Role role
) {
}
