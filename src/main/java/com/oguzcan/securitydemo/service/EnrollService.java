package com.oguzcan.securitydemo.service;

import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.exception.NotFoundException;
import com.oguzcan.securitydemo.mapper.EnrollMapper;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.repository.EnrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final EnrollMapper enrollMapper;

    public Enroll enrollCourse(StudentEnrollRequestDTO request) {
        Enroll enroll = enrollMapper.toEnroll(request);
        return enrollRepository.save(enroll);
    }

    @Transactional
    public void unEnrollCourse(StudentEnrollRequestDTO request) {
        var isNotExist = !enrollRepository.existsByStudent_IdAndCourse_Id(request.studentId(), request.courseId());
        if (isNotExist) {
            throw new NotFoundException("Id:" + request.studentId() + " bu öğrenci -> Id:" + request.courseId() + " bu kursa kayıtlı değil.");
        }
        enrollRepository.deleteByStudent_IdAndCourse_Id(request.studentId(), request.courseId());
    }

    public List<Enroll> getAllEnrolls() {
        return enrollRepository.findAll();
    }

    public Enroll getEnroll(Long enrollId) {
        return enrollRepository.findById(enrollId)
                .orElseThrow(() -> new NotFoundException("Id: " + enrollId + " -> Enroll bulunamadı."));
    }
}
