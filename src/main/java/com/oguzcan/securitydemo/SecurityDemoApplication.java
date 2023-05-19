package com.oguzcan.securitydemo;

import com.oguzcan.securitydemo.dto.request.UserRegisterRequestDTO;
import com.oguzcan.securitydemo.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.oguzcan.securitydemo.model.enums.Role.ADMIN;
import static com.oguzcan.securitydemo.model.enums.Role.TEACHER;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = UserRegisterRequestDTO.builder()
                    .username("admin")
                    .password("admin")
                    .firstname("oguzcan")
                    .lastname("oguz")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).accessToken());

            var teacher = UserRegisterRequestDTO.builder()
                    .username("teacher")
                    .password("teacher")
                    .firstname("tea")
                    .lastname("cher")
                    .role(TEACHER)
                    .build();
            System.out.println("Teacher token: " + service.register(teacher).accessToken());
        };
    }
}
