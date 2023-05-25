package com.oguzcan.securitydemo.controller;

import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enroll")
public class EnrollController {

    private final EnrollService enrollService;

    @PostMapping
    public ResponseEntity<Enroll> enrollStudent(StudentEnrollRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(enrollService.enrollCourse(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> unEnrollStudent(StudentEnrollRequestDTO request) {
        enrollService.unEnrollCourse(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Enroll>> getAllEnrolls() {
        return ResponseEntity.ok(enrollService.getAllEnrolls());
    }

    @GetMapping
    public ResponseEntity<Enroll> getEnroll(Long enrollId) {
        return ResponseEntity.ok(enrollService.getEnroll(enrollId));
    }
}
