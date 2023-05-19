package com.oguzcan.securitydemo.repository;

import com.oguzcan.securitydemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id);

    void deleteById(Long id);
}
