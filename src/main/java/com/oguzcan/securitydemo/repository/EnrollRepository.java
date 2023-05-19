package com.oguzcan.securitydemo.repository;

import com.oguzcan.securitydemo.model.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {
}
