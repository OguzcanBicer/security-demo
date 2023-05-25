package com.oguzcan.securitydemo.dto.request;

import lombok.Builder;

@Builder
public record StudentEnrollRequestDTO(
        Long courseId,

        Long studentId
) {
}
