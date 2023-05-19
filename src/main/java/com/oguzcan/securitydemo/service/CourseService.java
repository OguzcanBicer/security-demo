package com.oguzcan.securitydemo.service;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.mapper.CourseMapper;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.model.User;
import com.oguzcan.securitydemo.repository.CourseRepository;
import com.oguzcan.securitydemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseMapper courseMapper;
    public Course createCourse (CreateCourseRequestDTO request) {
        Course course = courseMapper.toCourse(request);
        final var auth = SecurityContextHolder.getContext().getAuthentication();
        log.info(auth.getName());
        log.info(auth.getDetails().toString());
        log.info(auth.getPrincipal().toString());
        log.info(auth.getAuthorities().toString());
        log.info(auth.getCredentials().toString());
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        username = ((UserDetails)principal).getUsername();
        var user = userRepository.findByUsername(username);
        log.info(user.get().toString());

        return courseRepository.findAll();
    }

    public Course getCourse(long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow();
    }

    public void deleteCourse(long courseId) {
        courseRepository.deleteById(courseId);
    }
}
