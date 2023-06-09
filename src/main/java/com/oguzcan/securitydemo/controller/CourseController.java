package com.oguzcan.securitydemo.controller;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(CreateCourseRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.createCourse(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping
    public ResponseEntity<Course> getCourse(Long courseId) {
        return ResponseEntity.ok(courseService.getCourse(courseId));
    }

    @PutMapping
    public ResponseEntity<?> setPassiveCourse(Long courseId) {
        return ResponseEntity.ok(courseService.setPassiveCourse(courseId));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCourse(Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
