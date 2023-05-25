package com.oguzcan.securitydemo;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.dto.request.UserRegisterRequestDTO;
import com.oguzcan.securitydemo.mapper.UserMapper;
import com.oguzcan.securitydemo.service.AuthenticationService;
import com.oguzcan.securitydemo.service.CourseService;
import com.oguzcan.securitydemo.service.EnrollService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.oguzcan.securitydemo.model.enums.Role.*;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService authService,
            CourseService courseService,
            EnrollService enrollService,
            UserMapper userMapper
    ) {
        return args -> {
            // 1L
            var admin = UserRegisterRequestDTO.builder()
                    .username("admin")
                    .password("admin")
                    .firstname("oguzcan")
                    .lastname("oguz")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + authService.register(admin).accessToken());

            // 2L
            var teacher = UserRegisterRequestDTO.builder()
                    .username("teacher")
                    .password("teacher")
                    .firstname("tea")
                    .lastname("cher")
                    .role(TEACHER)
                    .build();
            System.out.println("Teacher token: " + authService.register(teacher).accessToken());

            // 3L
            var student = UserRegisterRequestDTO.builder()
                    .username("student")
                    .password("student")
                    .firstname("calis")
                    .lastname("ders")
                    .role(STUDENT)
                    .build();
            System.out.println("Student token: " + authService.register(student).accessToken());

            // 4L
            var user = UserRegisterRequestDTO.builder()
                    .username("user")
                    .password("user")
                    .firstname("john")
                    .lastname("doe")
                    .role(USER)
                    .build();
            System.out.println("User token: " + authService.register(user).accessToken());

            // 1L
            var course = CreateCourseRequestDTO.builder()
                    .title("Math")
                    .classroom("3/C")
                    .teacherId(2L)
                    .build();
            courseService.createCourse(course);

            // 2L
            var course2 = CreateCourseRequestDTO.builder()
                    .title("History")
                    .classroom("History A")
                    .teacherId(2L)
                    .build();
            courseService.createCourse(course2);


            // 1L
            var enroll = StudentEnrollRequestDTO.builder()
                    .courseId(1L)
                    .studentId(3L)
                    .build();
            enrollService.enrollCourse(enroll);
        };
    }
}
