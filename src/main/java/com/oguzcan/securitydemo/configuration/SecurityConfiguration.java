package com.oguzcan.securitydemo.configuration;

import com.oguzcan.securitydemo.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.oguzcan.securitydemo.model.enums.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    private final CustomAuthenticationEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/api/v1/auth/**",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**",
                        "/swagger-ui.html"
                )
                .permitAll()

                .requestMatchers(GET, "/api/v1/**").permitAll()

                .requestMatchers("/api/v1/course/**").hasAnyRole(TEACHER.name(), ADMIN.name())
//                .requestMatchers("/api/v1/course/**").hasAnyAuthority("ROLE_STUDENT")
//                .requestMatchers("/api/v1/course/**").hasAnyAuthority(TEACHER_UPDATE.getPermission(), TEACHER_CREATE.getPermission(), TEACHER_DELETE.getPermission(), TEACHER_READ.getPermission())
                .requestMatchers(POST, "/api/v1/enroll/**").hasAnyRole(STUDENT.name(), ADMIN.name())
                .requestMatchers(PUT, "/api/v1/enroll/**").hasAnyRole(STUDENT.name(), ADMIN.name())
                .requestMatchers(DELETE, "/api/v1/enroll/**").hasAnyRole(STUDENT.name(), ADMIN.name())


                .requestMatchers("/api/**").hasRole(ADMIN.name())


                /* .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                 .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
                 .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
                 .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
                 .requestMatchers(DELETE, "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())*/


                .anyRequest()
                .authenticated()

                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)

                .and()

                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;

        return http.build();
    }
}
