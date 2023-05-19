package com.oguzcan.securitydemo.service;

import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.mapper.EnrollMapper;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.model.User;
import com.oguzcan.securitydemo.repository.EnrollRepository;
import com.oguzcan.securitydemo.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final EnrollMapper enrollMapper;

    public Enroll enrollCourse(StudentEnrollRequestDTO request) {
        Enroll enroll = enrollMapper.toEnroll(request);
        return enrollRepository.save(enroll);
    }

    public void unEnrollCourse(StudentEnrollRequestDTO request) {
        Enroll enroll = enrollMapper.toEnroll(request);
        enrollRepository.delete(enroll);
    }
}
