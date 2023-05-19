package com.oguzcan.securitydemo.controller;

import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enroll")
public class EnrollController {

    private final EnrollService enrollService;

    @PostMapping
    public ResponseEntity<Enroll> enrollStudent(StudentEnrollRequestDTO request) {
        return ResponseEntity.ok(enrollService.enrollCourse(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> unEnrollStudent(StudentEnrollRequestDTO request) {
        enrollService.unEnrollCourse(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
