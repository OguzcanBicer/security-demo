package com.oguzcan.securitydemo.service;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.exception.NotFoundException;
import com.oguzcan.securitydemo.mapper.CourseMapper;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public Course createCourse(CreateCourseRequestDTO request) {
        Course course = courseMapper.toCourse(request);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NotFoundException("Id:" + courseId + " -> Kurs bulunamadı."));
    }

    public Course setPassiveCourse(long courseId) {
        Course updatedCourse = courseRepository.findById(courseId)
                .map(course -> {
                    course.setActive(false);
                    return course;
                })
                .orElseThrow();
        return courseRepository.save(updatedCourse);
    }

    @Transactional
    public void deleteCourse(long courseId) {
        var isNotExist = !courseRepository.existsById(courseId);
        if (isNotExist)
            throw new NotFoundException("Id:" + courseId + " -> Silinecek kurs bulunamadı.");
        courseRepository.deleteById(courseId);
    }
}
