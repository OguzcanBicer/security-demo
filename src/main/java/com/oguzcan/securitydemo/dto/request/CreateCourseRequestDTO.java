package com.oguzcan.securitydemo.dto.request;

public record CreateCourseRequestDTO (
        String title,
        String classroom
) {
}
