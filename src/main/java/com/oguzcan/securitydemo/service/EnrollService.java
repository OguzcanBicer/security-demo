package com.oguzcan.securitydemo.service;

import com.oguzcan.securitydemo.repository.EnrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollService {

    private EnrollRepository enrollRepository;

    public void enrollCourse() {

    }

    public void unenrollCourse() {

    }
}
