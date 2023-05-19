package com.oguzcan.securitydemo.dto.request;

import lombok.Builder;

@Builder
public record CreateCourseRequestDTO (
        String title,
        String classroom
) {
}
