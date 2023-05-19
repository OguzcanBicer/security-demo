package com.oguzcan.securitydemo;

import com.oguzcan.securitydemo.dto.request.UserRegisterRequestDTO;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.repository.CourseRepository;
import com.oguzcan.securitydemo.repository.EnrollRepository;
import com.oguzcan.securitydemo.service.AuthenticationService;
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
            CourseRepository courseRepository,
            EnrollRepository enrollRepository
    ) {
        return args -> {
            var admin = UserRegisterRequestDTO.builder()
                    .username("admin")
                    .password("admin")
                    .firstname("oguzcan")
                    .lastname("oguz")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + authService.register(admin).accessToken());

            var teacher = UserRegisterRequestDTO.builder()
                    .username("teacher")
                    .password("teacher")
                    .firstname("tea")
                    .lastname("cher")
                    .role(TEACHER)
                    .build();
            System.out.println("Teacher token: " + authService.register(teacher).accessToken());

            var student = UserRegisterRequestDTO.builder()
                    .username("student")
                    .password("student")
                    .firstname("calis")
                    .lastname("ders")
                    .role(STUDENT)
                    .build();
            System.out.println("Student token: " + authService.register(student).accessToken());

            var user = UserRegisterRequestDTO.builder()
                    .username("user")
                    .password("user")
                    .firstname("john")
                    .lastname("doe")
                    .role(USER)
                    .build();
            System.out.println("User token: " + authService.register(user).accessToken());

            var course1 = Course.builder()
                    .title("Math")
                    .teacherId(2L)
                    .build();
            var course2 = Course.builder()
                    .title("History")
                    .teacherId(2L)
                    .build();
            courseRepository.save(course1);
            courseRepository.save(course2);

            var enroll = Enroll.builder()
                    .courseId(1L)
                    .studentId(3L)
                    .build();
            enrollRepository.save(enroll);
        };
    }
}
