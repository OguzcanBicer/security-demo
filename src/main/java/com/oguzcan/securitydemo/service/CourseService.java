package com.oguzcan.securitydemo.service;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.mapper.CourseMapper;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.repository.CourseRepository;
import com.oguzcan.securitydemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    public Course createCourse (CreateCourseRequestDTO request) {
        Course course = courseMapper.toCourse(request);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow();
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

    public void deleteCourse(long courseId) {
        courseRepository.deleteById(courseId);
    }
}
